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
	
	@GetMapping("/dresses")
	public String viewManageDresses(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Dresses> dresses = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-by-category/" + "Dresses", Dresses[].class));
		model.addAttribute("dresses", dresses);
		return "admin/clothes/manage_dresses";
	}
	
	@GetMapping("/edit-dresses/{id}")
	public String viewEditDresses(@PathVariable("id") int id, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		Dresses dresses = rest.getForObject("http://localhost:6969/rest/api/clothes/dresses/find-by-id/"+id, Dresses.class);
		model.addAttribute("dresses",dresses);
		return "admin/clothes/edit_dresses";
	}
	
	@PostMapping("/edit-dresses")
	public String updateDresses(@ModelAttribute("dresses") Dresses dresses, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/clothes/dresses/insert", dresses, Dresses.class);
		return "redirect:/admin/clothes/dresses";
	}
	
	@GetMapping("/delete-dresses/{id}")
	public String viewDeleteDresses(@PathVariable("id") int id, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.getForObject("http://localhost:6969/rest/api/clothes/dresses/delete-by-id/"+id, Integer.class);
		return "redirect:/admin/clothes/dresses";
	}
}
