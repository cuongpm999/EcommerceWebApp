package vn.ptit.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.Author;
import vn.ptit.models.book.BookItem;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.customer.Customer;
import vn.ptit.models.customer.CustomerMember;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.shoes.ShoesItem;

@Controller
@RequestMapping("/")
public class HomeController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public String home(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<BookItem> bookItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book-item/find-all", BookItem[].class));
		
		List<ElectronicsItem> electronicsItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics-item/find-all", ElectronicsItem[].class));
		
		List<ShoesItem> shoesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes-item/find-all", ShoesItem[].class));
		
		List<ClothesItem> clothesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes-item/find-all", ClothesItem[].class));
		
		model.addAttribute("bookItems", bookItems);
		model.addAttribute("electronicsItems", electronicsItems);
		model.addAttribute("shoesItems", shoesItems);
		model.addAttribute("clothesItems", clothesItems);
		return "home";
	}
}
