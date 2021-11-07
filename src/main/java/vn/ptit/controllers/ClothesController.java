package vn.ptit.controllers;

import java.util.ArrayList;
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
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.utils.FilterMap;

@Controller
@RequestMapping(value = "/clothes")
public class ClothesController {
	private RestTemplate rest = new RestTemplate();
	
	private int LIMIT = 3;
	@GetMapping
	public String viewAllClothes(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String price = req.getParameter("price");
		String color = req.getParameter("color");
		String style = req.getParameter("style");
		String material = req.getParameter("material");
		String sort = req.getParameter("sort");
		String pageNumber = req.getParameter("page");
		
		List<FilterMap> listFilter = new ArrayList<>();
		if (price != null) {
			FilterMap filter = new FilterMap("price", price);
			listFilter.add(filter);
			model.addAttribute("price", price);
		}
		if (color != null) {
			FilterMap filter = new FilterMap("color", color);
			listFilter.add(filter);
			model.addAttribute("color", color);
		}
		if (style != null) {
			FilterMap filter = new FilterMap("style", style);
			listFilter.add(filter);
			model.addAttribute("style", style);
		}
		if (material != null) {
			FilterMap filter = new FilterMap("material", material);
			listFilter.add(filter);
			model.addAttribute("material", material);
		}
		if (sort != null) {
			FilterMap filter = new FilterMap("sort", sort);
			listFilter.add(filter);
			model.addAttribute("sort", sort);
		}
		if (pageNumber != null) {
			FilterMap filter = new FilterMap("pageNumber", pageNumber);
			listFilter.add(filter);
		}
		
		List<ClothesItem> clothesItems = Arrays.asList(rest.postForObject("http://localhost:6969/rest/api/clothes-item/find-all-in-category", listFilter, ClothesItem[].class));
		model.addAttribute("clothesItems", clothesItems);
		return "category_clothes";
	}

	@GetMapping("/find-by-category/{categoryName}")
	public String viewClothesByCategory(@PathVariable String categoryName, ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		String price = req.getParameter("price");
		String color = req.getParameter("color");
		String style = req.getParameter("style");
		String material = req.getParameter("material");
		String sort = req.getParameter("sort");
		int pageNumber = 1;
		if(req.getParameter("page") != null) {
			pageNumber = Integer.parseInt(req.getParameter("page"));
		}

		List<FilterMap> listFilter = new ArrayList<>();

		if (categoryName != null) {
			FilterMap filter = new FilterMap("categoryName", categoryName);
			listFilter.add(filter);
		}
		if (price != null) {
			FilterMap filter = new FilterMap("price", price);
			listFilter.add(filter);
			model.addAttribute("price", price);
		}
		if (color != null) {
			FilterMap filter = new FilterMap("color", color);
			listFilter.add(filter);
			model.addAttribute("color", color);
		}
		if (style != null) {
			FilterMap filter = new FilterMap("style", style);
			listFilter.add(filter);
			model.addAttribute("style", style);
		}
		if (material != null) {
			FilterMap filter = new FilterMap("material", material);
			listFilter.add(filter);
			model.addAttribute("material", material);
		}
		if (sort != null) {
			FilterMap filter = new FilterMap("sort", sort);
			listFilter.add(filter);
			model.addAttribute("sort", sort);
		}
		
		
		List<ClothesItem> clothesItems = Arrays.asList(rest.postForObject("http://localhost:6969/rest/api/clothes-item/find-by-category", listFilter, ClothesItem[].class));
		
		List<ClothesItem> clothesItems1 = clothesItems.subList(
				(pageNumber - 1) * LIMIT > clothesItems.size() ? clothesItems.size() : (pageNumber - 1) * LIMIT,
				pageNumber * LIMIT > clothesItems.size() ? clothesItems.size() : pageNumber * LIMIT);
		model.addAttribute("clothesItems", clothesItems1);
		return "category_clothes";
	}

	@GetMapping(value = "/{slug}")
	public String viewClothesBySlug(@PathVariable String slug, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		List<ClothesItem> clothesItems = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/clothes-item/get-4-clothes-item/{slug}", ClothesItem[].class, slug));
//		ClothesItem clothesItemDetail = rest.postForObject("http://localhost:6969/rest/api/clothes-item/slug", slug, ClothesItem.class);
		ClothesItem clothesItemDetail = rest.getForObject("http://localhost:6969/rest/api/clothes-item/{slug}",
				ClothesItem.class, slug);
		Jeans jeans = rest.getForObject("http://localhost:6969/rest/api/clothes/jeans/{id}", Jeans.class,
				clothesItemDetail.getClothes().getId());
		Dresses dresses = rest.getForObject("http://localhost:6969/rest/api/clothes/dresses/{id}", Dresses.class,
				clothesItemDetail.getClothes().getId());
		SwimWear swimwear = rest.getForObject("http://localhost:6969/rest/api/clothes/swimwear/{id}", SwimWear.class,
				clothesItemDetail.getClothes().getId());
		model.addAttribute("clothesItems", clothesItems);
		model.addAttribute("clothesItemDetail", clothesItemDetail);
		model.addAttribute("jeans", jeans);
		model.addAttribute("dresses", dresses);
		model.addAttribute("swimwear", swimwear);
		return "clothes_detail";
	}

}