package vn.ptit.controllers;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.customer.CustomerMember;
import vn.ptit.models.customer.Account;

@Controller
public class CustomerController {

	private RestTemplate rest = new RestTemplate();

	@GetMapping(value = "/register")
	public String register(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("customerMember", new CustomerMember());
		return "register";
	}

	@PostMapping(value = "/register")
	public String registerPost(@ModelAttribute("customerMember") CustomerMember customerMember,
			@RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob, ModelMap model,
			HttpServletRequest req, HttpServletResponse resp) throws ParseException {
		customerMember.setDateOfBirth(dob);
		CustomerMember customerMember2 = rest.postForObject("http://localhost:6969/rest/api/customer/register",
				customerMember, CustomerMember.class);
		if (customerMember2 == null) {
			model.addAttribute("status", "trung-username");
			return "register";
		} else {
			model.addAttribute("status", "register-success");
			return "login";
		}
	}

	@GetMapping(value = "/login")
	public String login(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		return "login";
	}

	@PostMapping(value = "/login")
	public String loginPost(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Account account = new Account(username, password);
		CustomerMember customerMember = rest.postForObject("http://localhost:6969/rest/api/customer/login", account,
				CustomerMember.class);
		if (customerMember != null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("customer_username", customerMember.getAccount().getUsername());
			return "redirect:/";
		} else {
			model.addAttribute("status", "failed");
			return "login";
		}
	}
	
	@GetMapping(value = "/logout")
	public String logout(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession httpSession = req.getSession();
		httpSession.removeAttribute("customer_username");
		return "redirect:/";
	}
}
