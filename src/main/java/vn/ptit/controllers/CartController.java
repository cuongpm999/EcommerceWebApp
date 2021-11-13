package vn.ptit.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.BookItem;
import vn.ptit.models.customer.CustomerNew;
import vn.ptit.models.order.ShoppingCart;

@Controller
public class CartController {
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/cart")
	public String viewCart(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "cart";
	}
	
	@GetMapping("/choose-address")
	public String viewChooseAddress(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("customerNew", new CustomerNew());
		return "choose_address_view";
	}
	
	@GetMapping("/checkout")
	public String checkOut(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return "checkout";
	}
	
	@GetMapping("/my-order")
	public String myOrder(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
		return "myorder";
	}
	
}
