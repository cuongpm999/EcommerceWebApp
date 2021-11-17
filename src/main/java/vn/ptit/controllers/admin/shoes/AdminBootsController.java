package vn.ptit.controllers.admin.shoes;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.shoes.Boots;

@Controller
@RequestMapping("/admin/shoes")
public class AdminBootsController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-boots")
	public String viewAddBoots(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("boots",new Boots());
		return "admin/shoes/add_boots";
	}
	
	@PostMapping("/add-boots")
	public String addBoots(@ModelAttribute("boots") Boots boots, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/shoes/boots/insert", boots, Boots.class);
		return "admin/shoes/add_boots";
	}
	
	@GetMapping("/boots")
	public String viewManageBoots(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Boots> boots = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-by-category/" + "Boots", Boots[].class));
		model.addAttribute("boots", boots);
		return "admin/shoes/manage_boots";
	}
	
	
}
