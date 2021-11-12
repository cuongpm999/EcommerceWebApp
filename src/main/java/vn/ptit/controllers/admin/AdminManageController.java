package vn.ptit.controllers.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.Book;
import vn.ptit.models.book.BookItem;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.clothes.Dresses;
import vn.ptit.models.clothes.Jeans;
import vn.ptit.models.clothes.SwimWear;
import vn.ptit.models.electronics.Electronics;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.electronics.Laptop;
import vn.ptit.models.electronics.MobilePhone;
import vn.ptit.models.electronics.Tivi;
import vn.ptit.models.shoes.Boots;
import vn.ptit.models.shoes.HighHeels;
import vn.ptit.models.shoes.Shoes;
import vn.ptit.models.shoes.ShoesItem;
import vn.ptit.models.shoes.Sneaker;

@Controller
@RequestMapping("/admin/manage")
public class AdminManageController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping
	public String viewManage(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return "admin/manage";
	}

	@GetMapping("/book")
	public String viewManageBook(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Book> books = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book/find-all", Book[].class));
		model.addAttribute("books", books);
		return "admin/book/manage_book";
	}

	@GetMapping("/laptop")
	public String viewManageLaptop(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Laptop> laptops = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics/find-by-category/" + "Laptop", Laptop[].class));
		System.out.println(laptops.size());
		model.addAttribute("laptops", laptops);
		return "admin/electronics/manage_laptop";
	}

	@GetMapping("/mobilephone")
	public String viewManageMobilePhone(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<MobilePhone> mobilePhones = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics/find-by-category/" + "MobilePhone", MobilePhone[].class));
		model.addAttribute("mobilePhones", mobilePhones);
		return "admin/electronics/manage_mobilephone";
	}
	
	@GetMapping("/tivi")
	public String viewManageTivi(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Tivi> tivis = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics/find-by-category/" + "Tivi", Tivi[].class));
		model.addAttribute("tivis", tivis);
		return "admin/electronics/manage_tivi";
	}
	
	@GetMapping("/jeans")
	public String viewManageJeans(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Jeans> jeans = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-by-category/" + "Jeans", Jeans[].class));
		model.addAttribute("jeans", jeans);
		return "admin/clothes/manage_jeans";
	}
	
	@GetMapping("/dresses")
	public String viewManageDresses(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Dresses> dresses = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-by-category/" + "Dresses", Dresses[].class));
		model.addAttribute("dresses", dresses);
		return "admin/clothes/manage_dresses";
	}
	
	@GetMapping("/swimwear")
	public String viewManageSwimwear(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<SwimWear> swimwears = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes/find-by-category/" + "Swimwear", SwimWear[].class));
		model.addAttribute("swimwears", swimwears);
		return "admin/clothes/manage_swimwear";
	}
	
	@GetMapping("/sneaker")
	public String viewManageSneaker(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Sneaker> sneakers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-by-category/" + "Sneaker", Sneaker[].class));
		model.addAttribute("sneakers", sneakers);
		return "admin/shoes/manage_sneaker";
	}
	
	@GetMapping("/boots")
	public String viewManageBoots(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Boots> boots = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-by-category/" + "Boots", Boots[].class));
		model.addAttribute("boots", boots);
		return "admin/shoes/manage_boots";
	}
	
	@GetMapping("/highheels")
	public String viewManageHighHeels(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<HighHeels> highheels = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes/find-by-category/" + "HighHeels", HighHeels[].class));
		model.addAttribute("highheels", highheels);
		return "admin/shoes/manage_highheels";
	}
	
	// quản lý đưa lên trang web
	
	@GetMapping("/book-item")
	public String viewManageBookItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<BookItem> bookItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/book-item/find-all", BookItem[].class));
		model.addAttribute("bookItems", bookItems);
		return "admin/book/manage_bookItem";
	}
	
	@GetMapping("/electronics-item")
	public String viewManageElectronicsItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ElectronicsItem> electronicsItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/electronics-item/find-all", ElectronicsItem[].class));
		model.addAttribute("electronicsItems", electronicsItems);
		return "admin/electronics/manage_electronicsItem";
	}
	
	@GetMapping("/clothes-item")
	public String viewManageClothesItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ClothesItem> clothesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes-item/find-all", ClothesItem[].class));
		model.addAttribute("clothesItems", clothesItems);
		return "admin/clothes/manage_clothesItem";
	}
	
	@GetMapping("/shoes-item")
	public String viewManageShoesItem(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ShoesItem> shoesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shoes-item/find-all", ShoesItem[].class));
		model.addAttribute("shoesItems", shoesItems);
		return "admin/shoes/manage_shoesItem";
	}
}
