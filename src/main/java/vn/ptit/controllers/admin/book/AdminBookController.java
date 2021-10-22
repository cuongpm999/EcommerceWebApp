package vn.ptit.controllers.admin.book;

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

import vn.ptit.model.book.Book;
import vn.ptit.model.book.Publisher;
import vn.ptit.model.book.Author;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-book")
	public String viewAddBook(@ModelAttribute Book book, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Author> authors = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/author/find-all",Author[].class));
		List<Publisher> publishers = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/publisher/find-all",Publisher[].class));
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX" + authors.size());
		return "/admin/book/add_book";
	}
	
	@PostMapping("/add-book")
	public String addBook(@ModelAttribute Book book, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/book/insert", book, Book.class);
		return "/admin/book/add_book";
	}
}
