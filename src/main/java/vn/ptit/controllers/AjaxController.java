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

		ShoesItem shoesItem = new ShoesItem();
		BookItem bookItem = new BookItem();
		ClothesItem clothesItem = new ClothesItem();

		if (category.equalsIgnoreCase("electronics")) {
			ElectronicsItem electronicsItem = rest
					.getForObject("http://localhost:6969/rest/api/electronics-item/" + slug, ElectronicsItem.class);
			CartUtil.addToCart(electronicsItem, request);
		}

		CartUtil.tinhTongTien(request);
		CartUtil.tinhSoLuongMua(request);

		HttpSession httpSession = request.getSession();
		Integer soLuongMua = (Integer) httpSession.getAttribute("soLuongMua");
		return ResponseEntity.ok(new AjaxResponse(600, soLuongMua));
	}
}
