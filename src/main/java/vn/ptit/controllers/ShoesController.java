package vn.ptit.controllers;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.shoes.ShoesItem;

@Controller
@RequestMapping(value = "/shoes")
public class ShoesController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping
	public String viewAllClothes(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ShoesItem> shoesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes-item/find-all", ShoesItem[].class));
		model.addAttribute("shoesItems", shoesItems);
		return "category_shoes";
	}
}