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

import vn.ptit.model.clothes.Jeans;

@Controller
@RequestMapping("/admin/clothes")
public class AdminJeansController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-jeans")
	public String viewAddJeans(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("jeans",new Jeans());
		return "admin/clothes/add_jeans";
	}
	
	@PostMapping("/add-jeans")
	public String addSneaker(@ModelAttribute("jeans") Jeans jeans, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/clothes/jeans/insert", jeans, Jeans.class);
		return "admin/clothes/add_jeans";
	}
}
