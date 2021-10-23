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
import vn.ptit.models.electronics.Tivi;

@Controller
@RequestMapping("/admin/electronics")
public class AdminTiviController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-tivi")
	public String viewAddTivi(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Manufacturer> manufacturers =
				Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/manufacturer/find-all",Manufacturer[].class));
		model.addAttribute("manufacturers", manufacturers);
		Tivi tivi = new Tivi();
		model.addAttribute("tivi",tivi);
		return "admin/electronics/add_tivi";
	}
	
	@PostMapping("/add-tivi")
	public String addTivi(@ModelAttribute("tivi") Tivi tivi, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/electronics/tivi/insert", tivi, MobilePhone.class);
		return "admin/electronics/add_tivi";
	}
}
