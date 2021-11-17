package vn.ptit.controllers.admin.clothes;

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
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.clothes.SwimWear;

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
	
	@GetMapping("/swimwear")
	public String viewManageSwimwear(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<SwimWear> swimwears = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-by-category/" + "Swimwear", SwimWear[].class));
		model.addAttribute("swimwears", swimwears);
		return "admin/clothes/manage_swimwear";
	}
}
