package vn.ptit.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.Author;
import vn.ptit.models.book.BookItem;

@Controller
@RequestMapping("/")
public class HomeController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/")
	public String home(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<BookItem> bookItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book-item/find-all", BookItem[].class));
		model.addAttribute("bookItems", bookItems);
		return "home";
	}

}
