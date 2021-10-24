package vn.ptit.controllers.admin.book;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import vn.ptit.entities.ImgProduct;
import vn.ptit.entities.Product;
import vn.ptit.models.book.Author;
import vn.ptit.models.book.Book;
import vn.ptit.models.book.BookItem;
import vn.ptit.models.book.ImgBookItem;
import vn.ptit.models.book.Publisher;

@Controller
@RequestMapping("/admin")
public class AdminBookItemController {
	
	@Autowired 
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/add-bookitem")
	public String viewAddBookItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Book> books = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/book/find-all", Book[].class));
		model.addAttribute("books", books);
		model.addAttribute("bookItem", new BookItem());
		return "/admin/book/add_bookItem";
	}
	
	@PostMapping("/add-bookitem")
	public String addBookItem(@RequestParam("imgBookItem") MultipartFile[] imgBookItem, @ModelAttribute("bookItem") BookItem bookItem, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		if (imgBookItem != null && imgBookItem.length > 0) {
			for (MultipartFile multipartFile : imgBookItem) {
				if (multipartFile.getSize() <= 0)
					continue;
				ImgBookItem img = new ImgBookItem();
				img.setName(multipartFile.getOriginalFilename());
				img.setPath(null);
				img.setMime(null);
				product.addImgProduct(imgProduct);
				multipartFile.transferTo(new File(fileProduct + "/" + multipartFile.getOriginalFilename()));
			}
		}
	}
	
}
