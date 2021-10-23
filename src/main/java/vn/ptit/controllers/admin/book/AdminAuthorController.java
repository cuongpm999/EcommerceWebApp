package vn.ptit.controllers.admin.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.model.book.Author;

@Controller
@RequestMapping("/admin")
public class AdminAuthorController {
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-author")
	public String viewAddAuthor(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("author", new Author());
		return "/admin/book/add_author";
	}
	
	@PostMapping("/add-author")
	public String addAuthor(@ModelAttribute("author") Author author, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/author/insert", author, Author.class);
		return "/admin/book/add_author";
	}
}
