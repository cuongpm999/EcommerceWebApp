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
import vn.ptit.models.shoes.*;
import vn.ptit.utils.FilterMap;

@Controller
@RequestMapping(value = "/shoes")
public class ShoesController {
	private RestTemplate rest = new RestTemplate();

	private int LIMIT = 28;

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
		List<ShoesItem> shoesItems = Arrays.asList(rest.postForObject(
				"http://localhost:6969/rest/api/shoes-item/find-all-in-category", listFilter, ShoesItem[].class));
		model.addAttribute("shoesItems", shoesItems);
		return "category_shoes";
	}

	@GetMapping("/find-by-category/{categoryName}")
	public String viewShoesByCategory(@PathVariable String categoryName, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		String price = req.getParameter("price");
		String color = req.getParameter("color");
		String style = req.getParameter("style");
		String material = req.getParameter("material");
		String sort = req.getParameter("sort");
		int pageNumber = 1;

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
		List<ShoesItem> shoesItems = Arrays.asList(rest.postForObject(
				"http://localhost:6969/rest/api/shoes-item/find-by-category", listFilter, ShoesItem[].class));

		List<ShoesItem> shoesItems1 = shoesItems.subList(
				(pageNumber - 1) * LIMIT > shoesItems.size() ? shoesItems.size() : (pageNumber - 1) * LIMIT,
				pageNumber * LIMIT > shoesItems.size() ? shoesItems.size() : pageNumber * LIMIT);
		model.addAttribute("shoesItems", shoesItems);
		return "category_shoes";
	}

	@GetMapping(value = "/{slug}")
	public String viewShoesBySlug(@PathVariable String slug, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		List<ShoesItem> shoesItems = Arrays.asList(rest.getForObject(
				"http://localhost:6969/rest/api/shoes-item/get-4-shoes-item/{slug}", ShoesItem[].class, slug));
		ShoesItem shoesItemDetail = rest.getForObject("http://localhost:6969/rest/api/shoes-item/" + slug,
				ShoesItem.class);
		Sneaker sneaker = rest.getForObject("http://localhost:6969/rest/api/shoes/sneaker/{id}", Sneaker.class,
				shoesItemDetail.getShoes().getId());
		Boots boots = rest.getForObject("http://localhost:6969/rest/api/shoes/boots/{id}", Boots.class,
				shoesItemDetail.getShoes().getId());
		HighHeels highheels = rest.getForObject("http://localhost:6969/rest/api/shoes/highheels/{id}", HighHeels.class,
				shoesItemDetail.getShoes().getId());
		model.addAttribute("shoesItems", shoesItems);
		model.addAttribute("shoesItemDetail", shoesItemDetail);
		model.addAttribute("sneaker", sneaker);
		model.addAttribute("boots", boots);
		model.addAttribute("highheels", highheels);
		return "shoes_detail";
	}
}