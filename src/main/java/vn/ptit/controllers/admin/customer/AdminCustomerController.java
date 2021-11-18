package vn.ptit.controllers.admin.customer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
@RequestMapping("/admin/customer")
public class AdminCustomerController {
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public String viewListCustomer(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Customer> customers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/customer/find-all-customer", Customer[].class));
		
		model.addAttribute("customers", customers);
		return "/admin/manage_customer";
	}
	
	@GetMapping("/delete-customer/{id}")
	public String deleteCustomer(@PathVariable("id") int id, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		rest.getForObject("http://localhost:6969/rest/api/customer/delete-customer/"+id, Integer.class);		
		return "redirect:/admin/customer";
	}
	
}
