package vn.ptit.controllers;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ibm.icu.impl.UResource.Array;

import vn.ptit.models.clothes.Clothes;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.clothes.Dresses;
import vn.ptit.models.clothes.Jeans;
import vn.ptit.models.clothes.SwimWear;

@Controller
@RequestMapping(value = "/clothes")
public class ClothesController {
	private RestTemplate rest = new RestTemplate();

	@GetMapping
	public String viewAllClothes(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ClothesItem> clothesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes-item/find-all", ClothesItem[].class));
		model.addAttribute("clothesItems", clothesItems);
		return "category_clothes";
	}
	
	@GetMapping(value = "/{slug}")
	public String viewClothesBySlug(@PathVariable String slug, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<ClothesItem> clothesItems = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/clothes-item/find-all", ClothesItem[].class));
//		ClothesItem clothesItemDetail = rest.postForObject("http://localhost:6969/rest/api/clothes-item/slug", slug, ClothesItem.class);
		ClothesItem clothesItemDetail = rest.getForObject("http://localhost:6969/rest/api/clothes-item/{slug}", ClothesItem.class, slug);
		System.out.print(clothesItemDetail.getClothes().getId());
		Jeans jeans = rest.getForObject("http://localhost:6969/rest/api/clothes/jeans/{id}", Jeans.class, clothesItemDetail.getClothes().getId());
		Dresses dresses = rest.getForObject("http://localhost:6969/rest/api/clothes/dresses/{id}", Dresses.class, clothesItemDetail.getClothes().getId());
		SwimWear swimwear = rest.getForObject("http://localhost:6969/rest/api/clothes/swimwear/{id}", SwimWear.class, clothesItemDetail.getClothes().getId());
		model.addAttribute("clothesItems", clothesItems);
		model.addAttribute("clothesItemDetail", clothesItemDetail);
		model.addAttribute("jeans", jeans);
		model.addAttribute("dresses", dresses);
		model.addAttribute("swimwear", swimwear);
		System.out.print("-----"+clothesItems.size());
		return "clothes_detail";
	}
	
}