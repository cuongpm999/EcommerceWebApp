package vn.ptit.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sun.xml.internal.stream.Entity;

import vn.ptit.models.book.Author;
import vn.ptit.models.book.BookItem;
import vn.ptit.models.book.Publisher;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public String allBook(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String price = req.getParameter("price");
		String 
		List<BookItem> bookItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book-item/find-all", BookItem[].class));
		List<Author> authors = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/author/find-all", Author[].class));
		List<Publisher> publishers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/publisher/find-all", Publisher[].class));
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		model.addAttribute("bookItems", bookItems);
		return "/category_book";
	}
	
	@GetMapping(value="/{slug}")
	public String getBookItemBySlug(@PathVariable String slug, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		List<BookItem> bookItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book-item/find-all", BookItem[].class));
		BookItem bookItem = rest.postForObject("http://localhost:6969/rest/api/book-item/slug", slug, BookItem.class);
		model.addAttribute("bookItem", bookItem);
		model.addAttribute("bookItems", bookItems);
		return "book_detail";
	}
}
