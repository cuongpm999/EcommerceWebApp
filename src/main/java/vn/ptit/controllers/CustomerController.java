package vn.ptit.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.customer.CustomerMember;
import vn.ptit.models.customer.FullName;
import vn.ptit.utils.GooglePojo;
import vn.ptit.utils.GoogleUtils;
import vn.ptit.models.customer.Account;
import vn.ptit.models.customer.Address;

@Controller
public class CustomerController {

	private RestTemplate rest = new RestTemplate();
	@Autowired
	private GoogleUtils googleUtils;

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

		System.out.println(customerMember.getAccount().getUsername() + "XXXXXXx");

		boolean flagEmail = false;
		boolean flagUsername = false;
		List<CustomerMember> customerMembers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/customer/find-all", CustomerMember[].class));
		for (int i = 0; i < customerMembers.size(); i++) {
			if (customerMembers.get(i).getEmail().equalsIgnoreCase(customerMember.getEmail())) {
				flagEmail = true;
				break;
			}
		}
		for (int i = 0; i < customerMembers.size(); i++) {
			if (customerMembers.get(i).getAccount() != null && customerMembers.get(i).getAccount().getUsername() != null
					&& customerMembers.get(i).getAccount().getUsername().equalsIgnoreCase(customerMember.getAccount().getUsername())) {
				flagUsername = true;
				break;
			}
		}

		if (flagEmail || flagUsername) {
			if (flagEmail)
				model.addAttribute("status1", "faileEmailBiTrung");
			if (flagUsername)
				model.addAttribute("status2", "faileTenBiTrung");
			return "register";
		} else {
			rest.postForObject("http://localhost:6969/rest/api/customer/register", customerMember,
					CustomerMember.class);
			return "redirect:/login";
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
			httpSession.setAttribute("customerMemberLogin", customerMember);
			return "redirect:/";
		} else {
			model.addAttribute("status", "failed");
			return "login";
		}
	}

	@GetMapping(value = "/logout")
	public String logout(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession httpSession = req.getSession();
		httpSession.removeAttribute("customerMemberLogin");
		return "redirect:/";
	}

	@RequestMapping("/login-google")
	public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			return "redirect:/login?google=error";
		}
		String accessToken = googleUtils.getToken(code);

		GooglePojo googlePojo = googleUtils.getUserInfo(accessToken, request);
		System.out.println(googlePojo);

		Boolean flag = false;
		List<CustomerMember> customerMembers = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/customer/find-all", CustomerMember[].class));
		for (int i = 0; i < customerMembers.size(); i++) {
			if (customerMembers.get(i).getEmail().equalsIgnoreCase(googlePojo.getEmail())) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			CustomerMember customerMember = new CustomerMember();
			customerMember.setEmail(googlePojo.getEmail());
			FullName fullName = new FullName();
			fullName.setFirstName(googlePojo.getName());
			customerMember.setFullName(fullName);
			customerMember.setPoint(0);
			Address address = new Address(0, googlePojo.getLocale(), googlePojo.getLocale(), googlePojo.getLocale());
			customerMember.setAddress(address);
			rest.postForObject("http://localhost:6969/rest/api/customer/insert-by-social", customerMember,
					CustomerMember.class);

		}

		CustomerMember customerMember2 = rest.getForObject(
				"http://localhost:6969/rest/api/customer/get-by-email/" + googlePojo.getEmail(), CustomerMember.class);

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("customerMemberLogin", customerMember2);

		return "redirect:/";
	}

	@GetMapping(value = "/edit-profile")
	public String viewEditProfile(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession httpSession = req.getSession();
		CustomerMember customerMember = (CustomerMember) httpSession.getAttribute("customerMemberLogin");
		model.addAttribute("customerMember", customerMember);
		return "edit_profile";
	}

	@PostMapping(value = "/edit-profile")
	public String editProfile(@ModelAttribute("customerMember") CustomerMember customerMember,
			@RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob, ModelMap model,
			HttpServletRequest req, HttpServletResponse resp) throws ParseException {
		customerMember.setDateOfBirth(dob);

		boolean flagEmail = false;
		List<CustomerMember> customerMembers = Arrays.asList(
				rest.getForObject("http://localhost:6969/rest/api/customer/checkmail-edit/" + customerMember.getId(),
						CustomerMember[].class));
		for (int i = 0; i < customerMembers.size(); i++) {
			if (customerMembers.get(i).getEmail().equalsIgnoreCase(customerMember.getEmail())) {
				flagEmail = true;
				break;
			}
		}

		if (flagEmail) {
			model.addAttribute("status1", "faileEmailBiTrung");
			return "edit_profile";
		} else {
			customerMember = rest.postForObject("http://localhost:6969/rest/api/customer/edit-profile", customerMember,
					CustomerMember.class);
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("customerMemberLogin", customerMember);

			return "redirect:/";
		}
	}
}
