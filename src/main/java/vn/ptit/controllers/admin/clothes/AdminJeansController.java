package vn.ptit.controllers.admin.clothes;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.clothes.Jeans;

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
	
	@GetMapping("/jeans")
	public String viewManageJeans(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Jeans> jeans = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-by-category/" + "Jeans", Jeans[].class));
		model.addAttribute("jeans", jeans);
		return "admin/clothes/manage_jeans";
	}
	
	@GetMapping("/edit-jeans/{id}")
	public String viewEditJeans(@PathVariable("id") int id, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		Jeans jeans = rest.getForObject("http://localhost:6969/rest/api/clothes/jeans/find-by-id/"+id, Jeans.class);
		model.addAttribute("jeans",jeans);
		return "admin/clothes/edit_jeans";
	}
	
	@PostMapping("/edit-jeans")
	public String updateJeans(@ModelAttribute("jeans") Jeans jeans, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/clothes/jeans/insert", jeans, Jeans.class);
		return "redirect:/admin/clothes/jeans";
	}
	
	@GetMapping("/delete-jeans/{id}")
	public String viewDeleteJeans(@PathVariable("id") int id, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.getForObject("http://localhost:6969/rest/api/clothes/jeans/delete-by-id/"+id, Integer.class);
		return "redirect:/admin/clothes/jeans";
	}
}
