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

import vn.ptit.model.book.Publisher;

@Controller
@RequestMapping("/admin")
public class AdminPublisherController {
	
	private RestTemplate rest = new RestTemplate();
	
	@PostMapping("/add-publisher")
	public String addPublisher(@ModelAttribute("publisher") Publisher publisher, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/publisher/insert", publisher, Publisher.class);
		return "/admin/book/add_publisher";
	}
	
	@GetMapping("/add-publisher")
	public String viewAddPublisher(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("pulisher", new Publisher());
		return "/admin/book/add_publisher";
	}
}
