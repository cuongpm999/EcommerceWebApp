package vn.ptit.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import vn.ptit.models.customer.CustomerMember;
import vn.ptit.models.customer.CustomerNew;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.order.Cash;
import vn.ptit.models.order.Credit;
import vn.ptit.models.order.DigitalWallet;
import vn.ptit.models.order.Order;
import vn.ptit.models.order.Shipment;
import vn.ptit.models.order.ShoppingCart;
import vn.ptit.services.PaypalService;
import vn.ptit.utils.HelperOrder;
import vn.ptit.utils.PaymentUtil;

@Controller
public class OrderController {
	@Autowired
	PaypalService paypalService;

	private RestTemplate rest = new RestTemplate();

	@GetMapping("/cart")
	public String viewCart(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "cart";
	}

	@GetMapping("/cart/finish")
	public String checkCart(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			ShoppingCart shoppingCart = (ShoppingCart) httpSession.getAttribute("cart");
			if (shoppingCart.getLineBookItems().size() == 0 && shoppingCart.getLineClothesItems().size() == 0
					&& shoppingCart.getLineElectronicsItems().size() == 0
					&& shoppingCart.getLineShoesItems().size() == 0) {
				model.addAttribute("status", "emptyCart");
				return "cart";
			}
		}
		if (httpSession.getAttribute("customerMemberLogin") != null) {
			Order order = new Order();
			return "redirect:/checkout";
		}
		return "redirect:/choose-address";
	}

	@GetMapping("/choose-address")
	public String viewChooseAddress(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("customerNew", new CustomerNew());
		return "choose_address_view";
	}

	@PostMapping("/choose-address")
	public String chooseAddress(@ModelAttribute("customerNew") CustomerNew customerNew, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		ShoppingCart shoppingCart = new ShoppingCart();

		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		Order order = new Order();
		httpSession.setAttribute("customerNewBuy", customerNew);
		order.setShoppingCart(shoppingCart);
		httpSession.setAttribute("order", order);
		return "redirect:/checkout";
	}

	@GetMapping("/checkout")
	public String checkOut(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Shipment> shipments = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shipment/find-all", Shipment[].class));
		model.addAttribute("shipments", shipments);
		HttpSession httpSession = req.getSession();
		if (httpSession.getAttribute("customerMemberLogin") != null) {
			ShoppingCart shoppingCart = new ShoppingCart();

			if (httpSession.getAttribute("cart") != null) {
				shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
			}
			Order order = new Order();
			order.setShoppingCart(shoppingCart);
			httpSession.setAttribute("order", order);
		}
		return "checkout";
	}

	@PostMapping("/checkout/finish")
	public String checkOutFinish(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		int shipmentId = Integer.parseInt(req.getParameter("shipmentId"));

		String paymentType = req.getParameter("paymentType");
		String ccname = req.getParameter("cc-name");
		String ccnumber = req.getParameter("cc-number");
		String ccexpiration = req.getParameter("cc-expiration");

		System.out.println(paymentType);
		System.out.println(ccname);
		System.out.println(ccnumber);
		System.out.println(ccexpiration);

		HelperOrder helperOrder = new HelperOrder();

		HttpSession httpSession = req.getSession();
		Order order = new Order();
		if (httpSession.getAttribute("order") != null) {
			order = ((Order) httpSession.getAttribute("order"));
		}
		order.setDateCreate(new Date());
		order.setStatus("Chưa giao");
		Shipment shipment = rest.getForObject("http://localhost:6969/rest/api/shipment/find-one/" + shipmentId,
				Shipment.class);
		order.setShipment(shipment);

		if (ccname.isEmpty() && ccnumber.isEmpty() && ccexpiration.isEmpty()
				&& paymentType.equalsIgnoreCase("Chọn hình thức thanh toán")) {
			double allMoney = PaymentUtil.calTotalMoney(order.getShoppingCart(), shipment);
			Cash cash = new Cash(allMoney, allMoney);
			order.setPayment(cash);
			helperOrder.setCash(cash);

		}

		if (!ccname.isEmpty() && !ccnumber.isEmpty() && !ccexpiration.isEmpty()
				&& paymentType.equalsIgnoreCase("Chọn hình thức thanh toán")) {
			double allMoney = PaymentUtil.calTotalMoney(order.getShoppingCart(), shipment);
			Credit credit = new Credit(allMoney, ccnumber, ccname, ccexpiration);
			order.setPayment(credit);
			helperOrder.setCredit(credit);

		}

		if (httpSession.getAttribute("customerMemberLogin") != null) {
			CustomerMember customerMember = (CustomerMember) httpSession.getAttribute("customerMemberLogin");
			helperOrder.setCustomerMember(customerMember);
		}

		if (httpSession.getAttribute("customerNewBuy") != null) {
			CustomerNew customerNew = (CustomerNew) httpSession.getAttribute("customerNewBuy");
			helperOrder.setCustomerNew(customerNew);
		}

		helperOrder.setOrder(order);

		if (ccname.isEmpty() && ccnumber.isEmpty() && ccexpiration.isEmpty()
				&& !paymentType.equalsIgnoreCase("Chọn hình thức thanh toán")) {
			double allMoney = PaymentUtil.calTotalMoney(order.getShoppingCart(), shipment);
			DigitalWallet digitalWallet = new DigitalWallet(allMoney, paymentType);
			order.setPayment(digitalWallet);
			helperOrder.setDigitalWallet(digitalWallet);

			try {
				Payment payment = paypalService.createPayment(order.getPayment().getTotalMoney() * getTyGia(), "USD",
						"paypal", "sale", "test", "http://localhost:8080/checkout/finish/cancel",
						"http://localhost:8080/checkout/finish/success");
				httpSession.setAttribute("helperOrder", helperOrder);
				for (Links link : payment.getLinks()) {
					if (link.getRel().equals("approval_url")) {
						return "redirect:" + link.getHref();
					}
				}

			} catch (PayPalRESTException e) {

				e.printStackTrace();
			}

		} else {
			rest.postForObject("http://localhost:6969/rest/api/order/insert", helperOrder, Order.class);
			model.addAttribute("status", "success");
			httpSession.removeAttribute("order");
			httpSession.removeAttribute("cart");
			httpSession.removeAttribute("soLuongMua");
			httpSession.removeAttribute("customerNewBuy");
		}
		return "cart";
	}

	@GetMapping("/checkout/finish/cancel")
	public String cancelPay(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {

		model.addAttribute("status", "failePayPal");
		return "cart";
	}

	@GetMapping("/checkout/finish/success")
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			if (payment.getState().equals("approved")) {
				HttpSession httpSession = request.getSession();
				HelperOrder helperOrder = new HelperOrder();
				if (httpSession.getAttribute("helperOrder") != null) {
					helperOrder = (HelperOrder) httpSession.getAttribute("helperOrder");
				}

				rest.postForObject("http://localhost:6969/rest/api/order/insert", helperOrder, Order.class);

				model.addAttribute("status", "success");
				httpSession.removeAttribute("order");
				httpSession.removeAttribute("cart");
				httpSession.removeAttribute("soLuongMua");
				httpSession.removeAttribute("customerNewBuy");
				return "cart";
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}

		model.addAttribute("status", "failePayPal");
		return "cart";
	}

	public double getTyGia() {
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL(
					"https://free.currconv.com/api/v7/convert?apiKey=73186a7f4f40e1abc58c&q=VND_USD&compact=y");
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(url.openConnection().getInputStream()));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line);
			}
			bufferedReader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject object = new JSONObject(content.toString());
		JSONObject object1 = object.getJSONObject("VND_USD");
		double tyGia = object1.getDouble("val");
		return tyGia;
	}
	
	@GetMapping("/my-order")
	public String myOrder(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession httpSession = req.getSession();
		CustomerMember customerMember = (CustomerMember) httpSession.getAttribute("customerMemberLogin");
		List<Order> orders = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/order/get-order-by-customer/"+customerMember.getId(), Order[].class));
		model.addAttribute("myorders", orders);
		return "myorder";
	}
	
	@GetMapping("/my-order/change-status/{id}")
	public String changeStatus(@PathVariable("id") int id, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String status = id +";cancel";
		rest.postForObject("http://localhost:6969/rest/api/order/change-status", status, Order.class);
		return "redirect:/my-order";
	}

}
