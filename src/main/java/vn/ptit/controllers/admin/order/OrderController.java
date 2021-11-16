package vn.ptit.controllers.admin.order;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.order.Order;

@Controller
@RequestMapping("/admin")
public class OrderController {
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/order")
	public String viewAddBook(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Order> orders = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/order/find-all", Order[].class));
		model.addAttribute("orders", orders);
		return "/admin/order/all_order";
	}
	
}
