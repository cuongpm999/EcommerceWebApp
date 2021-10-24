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

import vn.ptit.models.clothes.Clothes;
import vn.ptit.models.clothes.Dresses;

@Controller
@RequestMapping("/admin")
public class AdminClothesController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-clothes")
	public String viewAddClothes(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("clothes", new Clothes());
		return "admin/clothes/add_clothes";
	}

	@PostMapping("/add-clothes")
	public String addClothes(@ModelAttribute("clothes") Clothes clothes, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/clothes/insert", clothes, Clothes.class);
		return "admin/clothes/add_clothes";
	}
}
