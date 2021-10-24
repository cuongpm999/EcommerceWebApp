package vn.ptit.controllers.admin.clothes;

import java.io.UnsupportedEncodingException;
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

import vn.ptit.models.book.Author;
import vn.ptit.models.clothes.Clothes;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.clothes.Dresses;

@Controller
@RequestMapping("/admin")
public class AdminClothesItemController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-clothes-item")
	public String viewAddClothesItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Clothes> clothes = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-all", Clothes[].class));
		model.addAttribute("clothes", clothes);
		model.addAttribute("clothesItem", new ClothesItem());
		return "admin/clothes/add_clothesItem";
	}
	
	@PostMapping("/add-clothes-item")
	public String addClothesItem(@ModelAttribute("clothesItem") ClothesItem clothesItem, ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		
		rest.postForObject("http://localhost:6969/rest/api/clothes/clothes-item/insert", clothesItem, ClothesItem.class);
		return "admin/clothes/add_clothesItem";
	}
}
