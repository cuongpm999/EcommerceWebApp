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

import vn.ptit.model.electronics.Laptop;
import vn.ptit.model.electronics.Manufacturer;
import vn.ptit.model.electronics.MobilePhone;

@Controller
@RequestMapping("/admin/electronics")
public class AdminMobilePhoneController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-mobilePhone")
	public String viewAddMobilePhone(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Manufacturer> manufacturers =
				Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/manufacturer/find-all",Manufacturer[].class));
		model.addAttribute("manufacturers", manufacturers);
		MobilePhone mobilePhone = new MobilePhone();
		model.addAttribute("mobilePhone",mobilePhone);
		return "admin/electronics/add_mobilePhone";
	}
	
	@PostMapping("/add-mobilePhone")
	public String addMobilePhone(@ModelAttribute("mobilePhone") MobilePhone mobilePhone, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/electronics/mobilePhone/insert", mobilePhone, MobilePhone.class);
		return "admin/electronics/add_mobilePhone";
	}
}
