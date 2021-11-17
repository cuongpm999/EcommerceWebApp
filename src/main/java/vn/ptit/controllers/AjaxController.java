package vn.ptit.controllers;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.BookItem;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.customer.Customer;
import vn.ptit.models.customer.CustomerNew;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.order.Order;
import vn.ptit.models.order.Shipment;
import vn.ptit.models.order.ShoppingCart;
import vn.ptit.models.shoes.ShoesItem;
import vn.ptit.utils.AjaxResponse;
import vn.ptit.utils.CartUtil;
import vn.ptit.utils.FilterMap;
import vn.ptit.utils.PaymentUtil;

@RestController
@RequestMapping("/rest/api")
public class AjaxController {
	private RestTemplate rest = new RestTemplate();

	@PostMapping(value = "/cart/addToCart")
	public ResponseEntity<AjaxResponse> addToCart(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {

		String slug = (String) data.get("slug");
		String category = (String) data.get("category");

		if (category.equalsIgnoreCase("electronics")) {
			ElectronicsItem electronicsItem = rest
					.getForObject("http://localhost:6969/rest/api/electronics-item/" + slug, ElectronicsItem.class);
			CartUtil.addToCart(electronicsItem, request);
		}

		if (category.equalsIgnoreCase("clothes")) {
			ClothesItem clothesItem = rest.getForObject("http://localhost:6969/rest/api/clothes-item/" + slug,
					ClothesItem.class);
			CartUtil.addToCart(clothesItem, request);
		}

		if (category.equalsIgnoreCase("shoes")) {
			ShoesItem shoesItem = rest.getForObject("http://localhost:6969/rest/api/shoes-item/" + slug,
					ShoesItem.class);
			CartUtil.addToCart(shoesItem, request);
		}

		if (category.equalsIgnoreCase("book")) {
			BookItem bookItem = rest.getForObject("http://localhost:6969/rest/api/book-item/" + slug, BookItem.class);
			CartUtil.addToCart(bookItem, request);
		}

		CartUtil.tinhTongTien(request);
		CartUtil.tinhSoLuongMua(request);

		HttpSession httpSession = request.getSession();
		Integer soLuongMua = (Integer) httpSession.getAttribute("soLuongMua");
		return ResponseEntity.ok(new AjaxResponse(600, soLuongMua));
	}

	@PostMapping(value = "/cart/editCart")
	public ResponseEntity<AjaxResponse> editCart(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {

		String slug = (String) data.get("slug");
		String category = (String) data.get("category");
		String quantity = (String) data.get("quantity");

		CartUtil.editCart(slug, quantity, category, request);

		CartUtil.tinhTongTien(request);
		CartUtil.tinhSoLuongMua(request);

		HttpSession httpSession = request.getSession();
		Integer soLuongMua = (Integer) httpSession.getAttribute("soLuongMua");

		// get thanh tien tung item trong cart
		ShoppingCart shoppingCart = new ShoppingCart();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		double thanhTien = 0;

		if (category.equalsIgnoreCase("electronics")) {
			for (int i = 0; i < shoppingCart.getLineElectronicsItems().size(); i++) {
				if (shoppingCart.getLineElectronicsItems().get(i).getElectronicsItem().getSlug()
						.equalsIgnoreCase(slug)) {
					int quanity = shoppingCart.getLineElectronicsItems().get(i).getQuanity();
					double discount = shoppingCart.getLineElectronicsItems().get(i).getElectronicsItem().getDiscount();
					double donGia = shoppingCart.getLineElectronicsItems().get(i).getElectronicsItem().getPrice();
					thanhTien = donGia * (100 - discount)/100 * quanity;
				}
			}
		}

		if (category.equalsIgnoreCase("book")) {
			for (int i = 0; i < shoppingCart.getLineBookItems().size(); i++) {
				if (shoppingCart.getLineBookItems().get(i).getBookItem().getSlug().equalsIgnoreCase(slug)) {
					int quanity = shoppingCart.getLineBookItems().get(i).getQuanity();
					double discount = shoppingCart.getLineBookItems().get(i).getBookItem().getDiscount();
					double donGia = shoppingCart.getLineBookItems().get(i).getBookItem().getPrice();
					thanhTien = donGia * (100 - discount)/100 * quanity;
				}
			}
		}

		if (category.equalsIgnoreCase("shoes")) {
			for (int i = 0; i < shoppingCart.getLineShoesItems().size(); i++) {
				if (shoppingCart.getLineShoesItems().get(i).getShoesItem().getSlug().equalsIgnoreCase(slug)) {
					int quanity = shoppingCart.getLineShoesItems().get(i).getQuanity();
					double discount = shoppingCart.getLineShoesItems().get(i).getShoesItem().getDiscount();
					double donGia = shoppingCart.getLineShoesItems().get(i).getShoesItem().getPrice();
					thanhTien = donGia * (100 - discount)/100 * quanity;
				}
			}
		}

		if (category.equalsIgnoreCase("clothes")) {
			for (int i = 0; i < shoppingCart.getLineClothesItems().size(); i++) {
				if (shoppingCart.getLineClothesItems().get(i).getClothesItem().getSlug().equalsIgnoreCase(slug)) {
					int quanity = shoppingCart.getLineClothesItems().get(i).getQuanity();
					double discount = shoppingCart.getLineClothesItems().get(i).getClothesItem().getDiscount();
					double donGia = shoppingCart.getLineClothesItems().get(i).getClothesItem().getPrice();
					thanhTien = donGia * (100 - discount)/100 * quanity;
				}
			}
		}
		
		Locale local = new Locale("vi", "VN");
		NumberFormat numberFormat = NumberFormat.getInstance(local);
		String price = numberFormat.format(thanhTien);
		String totalPrice = numberFormat.format(shoppingCart.getTotalAmount());
		List<String> helperMap = new ArrayList<>();
		helperMap.add(soLuongMua.toString());
		helperMap.add(price);
		helperMap.add(totalPrice);

		return ResponseEntity.ok(new AjaxResponse(400, helperMap));
	}
	
	@PostMapping(value = "/cart/deleteCart")
	public ResponseEntity<AjaxResponse> deleteCart(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		String slug = (String) data.get("slug");
		String category = (String) data.get("category");

		CartUtil.deleteCart(slug, category, request);

		CartUtil.tinhTongTien(request);
		CartUtil.tinhSoLuongMua(request);

		HttpSession httpSession = request.getSession();
		Integer soLuongMua = (Integer) httpSession.getAttribute("soLuongMua");
		return ResponseEntity.ok(new AjaxResponse(500, soLuongMua));
	}
	
	@PostMapping(value = "/shipment/select")
	public ResponseEntity<AjaxResponse> selectShipment(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		int idShipment = Integer.parseInt(data.get("idShipment").toString());
		Shipment shipment = rest.getForObject("http://localhost:6969/rest/api/shipment/find-one/"+idShipment, Shipment.class);
		
		Order order = new Order();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("order") != null) {
			order = ((Order) httpSession.getAttribute("order"));
		}
		double allMoney = PaymentUtil.calTotalMoney(order.getShoppingCart(), shipment);
		
		Locale local = new Locale("vi", "VN");
		NumberFormat numberFormat = NumberFormat.getInstance(local);
		FilterMap filterMap = new FilterMap(numberFormat.format(shipment.getPrice()),numberFormat.format(allMoney));
		return ResponseEntity.ok(new AjaxResponse(84, filterMap));
	}
	
	@PostMapping(value = "/customer/edit-address")
	public ResponseEntity<AjaxResponse> editAddress(@RequestBody final Map<String, Object> data, final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		int number = Integer.parseInt(data.get("number").toString());
		String street = data.get("street").toString();
		String district = data.get("district").toString();
		String city = data.get("city").toString();
		
		Order order = new Order();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("order") != null) {
			order = ((Order) httpSession.getAttribute("order"));
		}
		Customer customer = new Customer();
		if (httpSession.getAttribute("customerNewBuy") != null) {
			customer = ((Customer) httpSession.getAttribute("customerNewBuy"));
		}
		
		if (httpSession.getAttribute("customerMemberLogin") != null) {
			customer = ((Customer) httpSession.getAttribute("customerMemberLogin"));
		}
		
		customer.getAddress().setNumber(number);
		customer.getAddress().setStreet(street);
		customer.getAddress().setDistrict(district);
		customer.getAddress().setCity(city);
		
		return ResponseEntity.ok(new AjaxResponse(333, null));
	}

}
