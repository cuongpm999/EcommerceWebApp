package vn.ptit.controllers.admin.electronics;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import vn.ptit.models.electronics.Electronics;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.electronics.ImgElectronicsItem;
import vn.ptit.models.electronics.Laptop;
import vn.ptit.models.electronics.Manufacturer;
import vn.ptit.utils.CreateSlug;
import vn.ptit.utils.RandomString;

@Controller
@RequestMapping("/admin")
public class AdminElectronicsItemController {
	@Autowired
	Cloudinary cloudinary;

	@Value("${file.upload.path}")
	private String attachmentPath;

	private RestTemplate rest = new RestTemplate();

	@GetMapping("/add-electronics-item")
	public String viewAddElectronicsItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Electronics> electronics = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics/find-all", Electronics[].class));
		model.addAttribute("electronics", electronics);

		model.addAttribute("electronicsItem", new ElectronicsItem());
		return "admin/electronics/add_electronicsItem";
	}

	@PostMapping("/add-electronics-item")
	public String addElectronicsItem(@RequestParam("electronicsImage") MultipartFile[] electronicsImage,
			@ModelAttribute("electronicsItem") ElectronicsItem electronicsItem, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response)
			throws IllegalStateException, IOException {

		List<Electronics> electronics = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics/find-all", Electronics[].class));
		model.addAttribute("electronics", electronics);

		for (Electronics electronic : electronics) {
			if (electronic.getId() == electronicsItem.getElectronics().getId()) {
				electronicsItem.setElectronics(electronic);
				break;
			}
		}
		
		RandomString randomString = new RandomString(13, new SecureRandom(), RandomString.digits);
		electronicsItem.setBarCode(randomString.nextString());
		electronicsItem.setSlug(new CreateSlug().create(electronicsItem.getElectronics().getName()));
		List<ImgElectronicsItem> imgElectronicsItems = new ArrayList<>();

		Map uploadResult = null;
		if (electronicsImage != null && electronicsImage.length > 0) {
			for (MultipartFile multipartFile : electronicsImage) {
				if (multipartFile.getSize() <= 0)
					continue;
				ImgElectronicsItem imgElectronicsItem = new ImgElectronicsItem();
				imgElectronicsItem.setMime(multipartFile.getContentType());
				imgElectronicsItem.setPath(attachmentPath);
				uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(),
						ObjectUtils.asMap("resource_type", "auto", "folder", "EcommerceProject/ElectronicsItem"));
				imgElectronicsItem.setName((String) uploadResult.get("public_id") + '.'
						+ multipartFile.getContentType().substring(multipartFile.getContentType().indexOf('/') + 1));
				
				imgElectronicsItems.add(imgElectronicsItem);
			
			}
		}
		electronicsItem.setImgElectronicsItems(imgElectronicsItems);
		
		rest.postForObject("http://localhost:6969/rest/api/electronics-item/insert", electronicsItem,
				ElectronicsItem.class);

		return "admin/electronics/add_electronicsItem";
	}
	
	@GetMapping("/electronics-item")
	public String viewManageElectronicsItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ElectronicsItem> electronicsItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics-item/find-all", ElectronicsItem[].class));
		model.addAttribute("electronicsItems", electronicsItems);
		return "admin/electronics/manage_electronicsItem";
	}
	
	@GetMapping("/edit-electronics-item/{code}")
	public String viewEditElectronicsItem(@PathVariable("code") String code, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Electronics> electronics = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics/find-all", Electronics[].class));
		model.addAttribute("electronics", electronics);
		ElectronicsItem electronicsItem = rest.getForObject("http://localhost:6969/rest/api/electronics-item/find-by-code/"+code, ElectronicsItem.class);
		model.addAttribute("electronicsItem", electronicsItem);
		return "admin/electronics/edit_electronicsItem";
	}

	@PostMapping("/edit-electronics-item")
	public String editElectronicsItem(@ModelAttribute("electronicsItem") ElectronicsItem electronicsItem, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response)
			throws IllegalStateException, IOException {
	
		
		rest.postForObject("http://localhost:6969/rest/api/electronics-item/update", electronicsItem,
				ElectronicsItem.class);

		return "redirect:/admin/electronics-item";
	}
	
	@GetMapping("/delete-electronics-item/{code}")
	public String viewDeleteLaptop(@PathVariable("code") String code, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.getForObject("http://localhost:6969/rest/api/electronics-item/delete-by-code/"+code, Integer.class);
		return "redirect:/admin/electronics-item";
	}

}
