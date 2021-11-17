package vn.ptit.controllers.admin.order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.customer.Customer;
import vn.ptit.models.order.Order;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {
	
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/order")
	public String viewAddBook(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Order> orders = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/order/find-all", Order[].class));
		HashMap<Order, Customer> map = new HashMap<Order, Customer>();
		for(Order order : orders) {
			Customer customer = rest.getForObject("http://localhost:6969/rest/api/customer/get-customer-by-order/"+order.getId(), Customer.class);
			map.put(order, customer);
		}
		
		model.addAttribute("orders", map);
		return "/admin/order/all_order";
	}
	
	@GetMapping("/order/change-status/{id}")
	public String changeStatus(@PathVariable("id") int id, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String status = id +";delivered";
		rest.postForObject("http://localhost:6969/rest/api/order/change-status", status, Order.class);
		return "redirect:/admin/order";
	}
}
