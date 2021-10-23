package vn.ptit.controllers.admin.clothes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.clothes.Dresses;

@Controller
@RequestMapping("/admin/clothes")
public class AdminDressesController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping("/add-dresses")
	public String viewAddDresses(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("dresses", new Dresses());
		return "admin/clothes/add_dresses";
	}

	@PostMapping("/add-dresses")
	public String addDresses(@ModelAttribute("dresses") Dresses dresses, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/clothes/dresses/insert", dresses, Dresses.class);
		return "admin/clothes/add_dresses";
	}
}
