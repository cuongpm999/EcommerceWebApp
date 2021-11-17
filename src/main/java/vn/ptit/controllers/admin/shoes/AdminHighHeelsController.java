package vn.ptit.controllers.admin.shoes;

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

import vn.ptit.models.shoes.Boots;
import vn.ptit.models.shoes.HighHeels;

@Controller
@RequestMapping("/admin/shoes")
public class AdminHighHeelsController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping("/add-highheels")
	public String viewAddHighHeels(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("highheels", new HighHeels());
		return "admin/shoes/add_highheels";
	}

	@PostMapping("/add-highheels")
	public String addHighHeels(@ModelAttribute("highheels") HighHeels highheels, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/shoes/highheels/insert", highheels, HighHeels.class);
		return "admin/shoes/add_highheels";
	}
	
	@GetMapping("/highheels")
	public String viewManageHighHeels(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<HighHeels> highheels = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-by-category/" + "HighHeels", HighHeels[].class));
		model.addAttribute("highheels", highheels);
		return "admin/shoes/manage_highheels";
	}
}
