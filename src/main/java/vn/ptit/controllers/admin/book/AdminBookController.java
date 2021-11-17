package vn.ptit.controllers.admin.book;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.Book;
import vn.ptit.models.book.Publisher;
import vn.ptit.models.book.Author;

@Controller
@RequestMapping("/admin")
public class AdminBookController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping("/add-book")
	public String viewAddBook(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Author> authors = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/author/find-all", Author[].class));
		List<Publisher> publishers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/publisher/find-all", Publisher[].class));
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		model.addAttribute("book", new Book());
		return "/admin/book/add_book";
	}

	@PostMapping("/add-book")
	public String addBook(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		int pages = Integer.parseInt(request.getParameter("pages"));
		String language = request.getParameter("language");
		String[] authorsId = request.getParameterValues("authors");
		int publisherId = Integer.parseInt(request.getParameter("publisherId"));
		List<Author> authors = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/author/find-all", Author[].class));
		List<Publisher> publishers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/publisher/find-all", Publisher[].class));
		model.addAttribute("authors", authors);
		model.addAttribute("publishers", publishers);
		List<Author> listAuthor = new ArrayList<Author>();
		for (int i = 0; i < authors.size(); i++) {
			for (int j = 0; j < authorsId.length; j++) {
				if (authors.get(i).getId() == Integer.parseInt(authorsId[j])) {
					listAuthor.add(authors.get(i));
				}
			}
		}
		Book book = new Book();
		for (int i = 0; i < publishers.size(); i++) {
			if (publishers.get(i).getId() == publisherId) {
				book.setPublisher(publishers.get(i));
			}
		}
		book.setAuthors(listAuthor);
		book.setLanguage(language);
		book.setPages(pages);
		book.setSummary(summary);
		book.setTitle(title);
		rest.postForObject("http://localhost:6969/rest/api/book/insert", book, Book.class);
		return "/admin/book/add_book";
	}
	
	@GetMapping("/book")
	public String viewManageBook(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Book> books = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book/find-all", Book[].class));
		model.addAttribute("books", books);
		return "admin/book/manage_book";
	}
}
