package vn.ptit.controllers.admin.book;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import vn.ptit.models.book.Book;
import vn.ptit.models.book.BookItem;
import vn.ptit.models.book.ImgBookItem;
import vn.ptit.utils.CreateSlug;
import vn.ptit.utils.RandomString;

@Controller
@RequestMapping("/admin")
public class AdminBookItemController {

	@Autowired
	Cloudinary cloudinary;

	@Value("${file.upload.path}")
	private String attachmentPath;

	private RestTemplate rest = new RestTemplate();

	@GetMapping("/add-book-item")
	public String viewAddBookItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Book> books = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book/find-all", Book[].class));
		model.addAttribute("books", books);
		model.addAttribute("bookItem", new BookItem());
		return "/admin/book/add_bookItem";
	}

	@PostMapping("/add-book-item")
	public String addBookItem(@RequestParam("imgBookItem") MultipartFile[] imgBookItem,
			@ModelAttribute("bookItem") BookItem bookItem, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		List<Book> books = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book/find-all", Book[].class));
		model.addAttribute("books", books);

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookItem.getBook().getId()) {
				bookItem.setBook(books.get(i));
			}
		}

		RandomString randomString = new RandomString(13, new SecureRandom(), RandomString.digits);
		bookItem.setBarCode(randomString.nextString());
		bookItem.setSlug(new CreateSlug().create(bookItem.getBook().getTitle()));

		List<ImgBookItem> listImgBookItems = new ArrayList<ImgBookItem>();

		Map uploadResult = null;

		if (imgBookItem != null && imgBookItem.length > 0) {
			for (MultipartFile multipartFile : imgBookItem) {
				if (multipartFile.getSize() <= 0)
					continue;
				ImgBookItem img = new ImgBookItem();
				img.setMime(multipartFile.getContentType());
				img.setPath(attachmentPath);
				uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(),
						ObjectUtils.asMap("resource_type", "auto", "folder", "EcommerceProject/BookItem"));
				img.setName((String) uploadResult.get("public_id") + '.'
						+ multipartFile.getContentType().substring(multipartFile.getContentType().indexOf('/') + 1));
				listImgBookItems.add(img);
			}
		}

		bookItem.setImgBookItems(listImgBookItems);
		rest.postForObject("http://localhost:6969/rest/api/book-item/insert", bookItem, BookItem.class);

		return "redirect:/admin/book-item";
	}

	@GetMapping("/book-item")
	public String viewManageBookItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<BookItem> bookItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book-item/find-all", BookItem[].class));
		model.addAttribute("bookItems", bookItems);
		return "admin/book/manage_bookItem";
	}

	@GetMapping("/edit-book-item/{code}")
	public String editBookItem(@PathVariable("code") String code, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		BookItem bookItem = rest.getForObject("http://localhost:6969/rest/api/book-item/find-by-code/" + code,
				BookItem.class);
		model.addAttribute("bookItem", bookItem);
		return "admin/book/edit_bookItem";
	}

	@PostMapping("/edit-book-item")
	public String editBookItem(@ModelAttribute("bookItem") BookItem bookItem, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response)
			throws IllegalStateException, IOException {

		rest.postForObject("http://localhost:6969/rest/api/book-item/update", bookItem, BookItem.class);

		return "redirect:/admin/book-item";
	}

	@GetMapping("/delete-book-item/{code}")
	public String deleteBookItem(@PathVariable("code") String code, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		rest.getForObject("http://localhost:6969/rest/api/book-item/delete-by-code/" + code, Integer.class);
		return "redirect:/admin/book-item";
	}

}
