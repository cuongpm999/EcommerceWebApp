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

import vn.ptit.models.shoes.HighHeels;
import vn.ptit.models.shoes.Sneaker;

@Controller
@RequestMapping("/admin/shoes")
public class AdminSneakerController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-sneaker")
	public String viewAddSneaker(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("sneaker", new Sneaker());
		return "admin/shoes/add_sneaker";
	}

	@PostMapping("/add-sneaker")
	public String addSneaker(@ModelAttribute("sneaker") Sneaker sneaker, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/shoes/sneaker/insert", sneaker, Sneaker.class);
		return "admin/shoes/add_sneaker";
	}
	
	@GetMapping("/sneaker")
	public String viewManageSneaker(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Sneaker> sneakers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-by-category/" + "Sneaker", Sneaker[].class));
		model.addAttribute("sneakers", sneakers);
		return "admin/shoes/manage_sneaker";
	}
}
