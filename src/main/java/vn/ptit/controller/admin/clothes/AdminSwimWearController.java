package vn.ptit.controller.admin.clothes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.model.clothes.SwimWear;

@Controller
@RequestMapping("/admin/clothes")
public class AdminSwimWearController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping("/add-swimwear")
	public String viewAddSwimWear(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("swimwear", new SwimWear());
		return "admin/clothes/add_swimwear";
	}

	@PostMapping("/add-swimwear")
	public String addDresses(@ModelAttribute("swimwear") SwimWear swimwear, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/clothes/swimwear/insert", swimwear, SwimWear.class);
		return "admin/clothes/add_swimwear";
	}
}
