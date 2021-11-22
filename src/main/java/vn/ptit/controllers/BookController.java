package vn.ptit.controllers;

import java.util.ArrayList;
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

import vn.ptit.models.book.Author;
import vn.ptit.models.book.BookItem;
import vn.ptit.models.book.Publisher;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.electronics.Manufacturer;
import vn.ptit.utils.FilterMap;

@Controller
@RequestMapping("/book")
public class BookController {

	private RestTemplate rest = new RestTemplate();

	@GetMapping
	public String viewAllBook(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String price = req.getParameter("price");
		String sort = req.getParameter("sort");
		String pageNumber = req.getParameter("page");

		List<FilterMap> listFilter = new ArrayList<>();
		if (price != null) {
			FilterMap filter = new FilterMap("price", price);
			listFilter.add(filter);
			model.addAttribute("price", price);
		}
		if (sort != null) {
			FilterMap filter = new FilterMap("sort", sort);
			listFilter.add(filter);
			model.addAttribute("sort", sort);
		}
		if (pageNumber != null) {
			FilterMap filter = new FilterMap("pageNumber", pageNumber);
			listFilter.add(filter);
		}
		List<BookItem> bookItems = Arrays.asList(rest.postForObject(
				"http://localhost:6969/rest/api/book-item/find-all-in-category", listFilter, BookItem[].class));
		List<Author> authors = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/author/find-all", Author[].class));
		List<Publisher> publishers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/publisher/find-all", Publisher[].class));
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		model.addAttribute("bookItems", bookItems);
		return "category_book";
	}

	@GetMapping("/find-by-author/{idAuthor}")
	public String viewBookByAuthor(@PathVariable String idAuthor, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		String price = req.getParameter("price");
		String sort = req.getParameter("sort");

		List<FilterMap> listFilter = new ArrayList<>();
		if (idAuthor != null) {
			FilterMap filter = new FilterMap("idAuthor", idAuthor);
			listFilter.add(filter);
		}
		if (price != null) {
			FilterMap filter = new FilterMap("price", price);
			listFilter.add(filter);
			model.addAttribute("price", price);
		}
		if (sort != null) {
			FilterMap filter = new FilterMap("sort", sort);
			listFilter.add(filter);
			model.addAttribute("sort", sort);
		}

		List<Author> authors = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/author/find-all", Author[].class));
		List<Publisher> publishers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/publisher/find-all", Publisher[].class));
		List<BookItem> bookItems = Arrays.asList(rest.postForObject(
				"http://localhost:6969/rest/api/book-item/find-by-author", listFilter, BookItem[].class));
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		model.addAttribute("bookItems", bookItems);
		return "category_book";
	}

	@GetMapping("/find-by-publisher/{idPublisher}")
	public String viewBookByPublisher(@PathVariable String idPublisher, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		String price = req.getParameter("price");
		String sort = req.getParameter("sort");

		List<FilterMap> listFilter = new ArrayList<>();
		if (idPublisher != null) {
			FilterMap filter = new FilterMap("idPublisher", idPublisher);
			listFilter.add(filter);
		}
		if (price != null) {
			FilterMap filter = new FilterMap("price", price);
			listFilter.add(filter);
			model.addAttribute("price", price);
		}
		if (sort != null) {
			FilterMap filter = new FilterMap("sort", sort);
			listFilter.add(filter);
			model.addAttribute("sort", sort);
		}

		List<Author> authors = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/author/find-all", Author[].class));
		List<Publisher> publishers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/publisher/find-all", Publisher[].class));
		List<BookItem> bookItems = Arrays.asList(rest.postForObject(
				"http://localhost:6969/rest/api/book-item/find-by-publisher", listFilter, BookItem[].class));
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		model.addAttribute("bookItems", bookItems);
		return "category_book";
	}

	@GetMapping(value = "/{slug}")
	public String getBookItemBySlug(@PathVariable String slug, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		List<BookItem> bookItems = Arrays.asList(
				rest.getForObject("http://localhost:6969/rest/api/book-item/same-item/" + slug, BookItem[].class));
		model.addAttribute("bookItems", bookItems);

		BookItem bookItem = rest.getForObject("http://localhost:6969/rest/api/book-item/" + slug, BookItem.class);
		model.addAttribute("bookItem", bookItem);
		return "book_detail";
	}
}
