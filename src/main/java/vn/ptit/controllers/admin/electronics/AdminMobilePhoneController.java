package vn.ptit.controllers.admin.electronics;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.electronics.Laptop;
import vn.ptit.models.electronics.Manufacturer;
import vn.ptit.models.electronics.MobilePhone;

@Controller
@RequestMapping("/admin/electronics")
public class AdminMobilePhoneController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-mobilephone")
	public String viewAddMobilePhone(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Manufacturer> manufacturers =
				Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/manufacturer/find-all",Manufacturer[].class));
		model.addAttribute("manufacturers", manufacturers);
		MobilePhone mobilePhone = new MobilePhone();
		model.addAttribute("mobilePhone",mobilePhone);
		return "admin/electronics/add_mobilePhone";
	}
	
	@PostMapping("/add-mobilephone")
	public String addMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/electronics/mobilephone/insert", mobilePhone, MobilePhone.class);
		List<Manufacturer> manufacturers =
				Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/manufacturer/find-all",Manufacturer[].class));
		model.addAttribute("manufacturers", manufacturers);
		return "admin/electronics/add_mobilePhone";
	}
	
	@GetMapping("/mobilephone")
	public String viewManageMobilePhone(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<MobilePhone> mobilePhones = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics/find-by-category/" + "MobilePhone", MobilePhone[].class));
		model.addAttribute("mobilePhones", mobilePhones);
		return "admin/electronics/manage_mobilephone";
	}
}
