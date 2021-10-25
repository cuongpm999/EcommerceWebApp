package vn.ptit.controllers.admin.shoes;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import vn.ptit.models.shoes.Shoes;
import vn.ptit.models.shoes.ShoesItem;
import vn.ptit.models.shoes.ImgShoesItem;
import vn.ptit.utils.CreateSlug;
import vn.ptit.utils.RandomString;

@Controller
@RequestMapping("/admin")
public class AdminShoesItemController {
@Autowired Cloudinary cloudinary;
	
	@Value("${file.upload.path}")
	private String attachmentPath;
	
	private RestTemplate rest = new RestTemplate();
	@GetMapping("/add-shoes-item")
	public String viewAddShoesItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Shoes> shoes = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-all", Shoes[].class));
		model.addAttribute("shoes", shoes);
		model.addAttribute("shoesItem", new ShoesItem());
		return "admin/shoes/add_shoesItem";
	}
	
	@PostMapping("/add-shoes-item")
	public String addShoesItem(@RequestParam("shoesImage") MultipartFile[] shoesImage,
			@ModelAttribute("shoesItem") ShoesItem shoesItem, ModelMap model, HttpServletRequest req, HttpServletResponse resp) 
					throws IOException {
		List<Shoes> shoes = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-all", Shoes[].class));
		model.addAttribute("shoes", shoes);
		for (Shoes shoe : shoes) {
			if(shoe.getId() == shoesItem.getShoes().getId()) {
				shoesItem.setShoes(shoe);
				break;
			}
		}
		RandomString randomString = new RandomString(13, new SecureRandom(), RandomString.digits);
		shoesItem.setBarCode(randomString.nextString());
		shoesItem.setSlug(new CreateSlug().create(shoesItem.getShoes().getName()));
		List<ImgShoesItem> imgShoesItems = new ArrayList<>();

		Map uploadResult = null;
		if (shoesImage != null && shoesImage.length > 0) {
			for (MultipartFile multipartFile : shoesImage) {
				if (multipartFile.getSize() <= 0)
					continue;
				ImgShoesItem imgShoesItem = new ImgShoesItem();
				imgShoesItem.setMime(multipartFile.getContentType());
				imgShoesItem.setPath(attachmentPath);
				uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(),
						ObjectUtils.asMap("resource_type", "auto", "folder", "EcommerceProject/ShoesItem"));
				imgShoesItem.setName((String) uploadResult.get("public_id") + '.'
						+ multipartFile.getContentType().substring(multipartFile.getContentType().indexOf('/') + 1));
				
				imgShoesItems.add(imgShoesItem);
			}
		}
		shoesItem.setImgShoesItems(imgShoesItems);
		rest.postForObject("http://localhost:6969/rest/api/shoes-item/insert", shoesItem, ShoesItem.class);
		return "admin/shoes/add_shoesItem";
	}
}
