package vn.ptit.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.BookItem;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.shoes.ShoesItem;
import vn.ptit.utils.AjaxResponse;
import vn.ptit.utils.CartUtil;

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
			ClothesItem clothesItem = rest
					.getForObject("http://localhost:6969/rest/api/clothes-item/" + slug, ClothesItem.class);
			CartUtil.addToCart(clothesItem, request);
		}
		
		if (category.equalsIgnoreCase("shoes")) {
			ShoesItem shoesItem = rest
					.getForObject("http://localhost:6969/rest/api/shoes-item/" + slug, ShoesItem.class);
			CartUtil.addToCart(shoesItem, request);
		}
		
		if (category.equalsIgnoreCase("book")) {
			BookItem bookItem = rest
					.getForObject("http://localhost:6969/rest/api/book-item/" + slug, BookItem.class);
			CartUtil.addToCart(bookItem, request);
		}

		CartUtil.tinhTongTien(request);
		CartUtil.tinhSoLuongMua(request);

		HttpSession httpSession = request.getSession();
		Integer soLuongMua = (Integer) httpSession.getAttribute("soLuongMua");
		return ResponseEntity.ok(new AjaxResponse(600, soLuongMua));
	}
}
