package vn.ptit.controllers.admin.clothes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import vn.ptit.models.clothes.Clothes;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.clothes.ImgClothesItem;
import vn.ptit.utils.CreateSlug;
import vn.ptit.utils.RandomString;

@Controller
@RequestMapping("/admin")
public class AdminClothesItemController {
	@Autowired Cloudinary cloudinary;
	
	@Value("${file.upload.path}")
	private String attachmentPath;
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-clothes-item")
	public String viewAddClothesItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Clothes> clothes = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-all", Clothes[].class));
		model.addAttribute("clothes", clothes);
		model.addAttribute("clothesItem", new ClothesItem());
		return "admin/clothes/add_clothesItem";
	}
	
	@PostMapping("/add-clothes-item")
	public String addClothesItem(@RequestParam("clothesImage") MultipartFile[] clothesImage,
			@ModelAttribute("clothesItem") ClothesItem clothesItem, ModelMap model, HttpServletRequest req, HttpServletResponse resp) 
					throws IOException {
		req.setCharacterEncoding("UTF-8");
		List<Clothes> clothes = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-all", Clothes[].class));
		model.addAttribute("clothes", clothes);
		for (Clothes clothe : clothes) {
			if(clothe.getId() == clothesItem.getClothes().getId()) {
				clothesItem.setClothes(clothe);
				break;
			}
		}
		RandomString randomString = new RandomString(13, new SecureRandom(), RandomString.digits);
		clothesItem.setBarCode(randomString.nextString());
		clothesItem.setSlug(new CreateSlug().create(clothesItem.getClothes().getName()));
		List<ImgClothesItem> imgClothesItems = new ArrayList<>();

		Map uploadResult = null;
		if (clothesImage != null && clothesImage.length > 0) {
			for (MultipartFile multipartFile : clothesImage) {
				if (multipartFile.getSize() <= 0)
					continue;
				ImgClothesItem imgClothesItem = new ImgClothesItem();
				imgClothesItem.setMime(multipartFile.getContentType());
				imgClothesItem.setPath(attachmentPath);
				uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(),
						ObjectUtils.asMap("resource_type", "auto", "folder", "EcommerceProject/ClothesItem"));
				imgClothesItem.setName((String) uploadResult.get("public_id") + '.'
						+ multipartFile.getContentType().substring(multipartFile.getContentType().indexOf('/') + 1));
				
				imgClothesItems.add(imgClothesItem);
			}
		}
		clothesItem.setImgClothesItems(imgClothesItems);
		rest.postForObject("http://localhost:6969/rest/api/clothes-item/insert", clothesItem, ClothesItem.class);
		return "admin/clothes/add_clothesItem";
	}
	
	@GetMapping("/clothes-item")
	public String viewManageClothesItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ClothesItem> clothesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes-item/find-all", ClothesItem[].class));
		model.addAttribute("clothesItems", clothesItems);
		return "admin/clothes/manage_clothesItem";
	}
}
