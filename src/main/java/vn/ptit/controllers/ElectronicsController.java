package vn.ptit.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.electronics.Manufacturer;
import vn.ptit.models.electronics.MobilePhone;
import vn.ptit.utils.FilterMap;

@Controller
@RequestMapping("/electronics")
public class ElectronicsController {
	private RestTemplate rest = new RestTemplate();
	private int LIMIT = 3;

	@GetMapping
	public String viewAllElectronics(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		String price = req.getParameter("price");
		String screendSize = req.getParameter("screendSize");
		String sort = req.getParameter("sort");
		String pageNumber = req.getParameter("page");

		List<FilterMap> listFilter = new ArrayList<>();
		if (price != null) {
			FilterMap filter = new FilterMap("price", price);
			listFilter.add(filter);
			model.addAttribute("price", price);
		}
		if (screendSize != null) {
			FilterMap filter = new FilterMap("screendSize", screendSize);
			listFilter.add(filter);
			model.addAttribute("screendSize", screendSize);
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

		List<ElectronicsItem> electronicsItems = Arrays
				.asList(rest.postForObject("http://localhost:6969/rest/api/electronics-item/find-all-in-category",
						listFilter, ElectronicsItem[].class));
		model.addAttribute("electronicsItems", electronicsItems);

		List<Manufacturer> manufacturers = Arrays.asList(
				rest.getForObject("http://localhost:6969/rest/api/manufacturer/find-all", Manufacturer[].class));
		model.addAttribute("manufacturers", manufacturers);

		return "category_electronics";
	}

	@GetMapping("/find-by-category/{categoryName}")
	public String viewElectronicsByCategory(@PathVariable String categoryName, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		String price = req.getParameter("price");
		String screendSize = req.getParameter("screendSize");
		String sort = req.getParameter("sort");
		int pageNumber = 1;
		if (req.getParameter("page") != null) {
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
		if (screendSize != null) {
			FilterMap filter = new FilterMap("screendSize", screendSize);
			listFilter.add(filter);
			model.addAttribute("screendSize", screendSize);
		}
		if (sort != null) {
			FilterMap filter = new FilterMap("sort", sort);
			listFilter.add(filter);
			model.addAttribute("sort", sort);
		}

		List<ElectronicsItem> electronicsItems = Arrays
				.asList(rest.postForObject("http://localhost:6969/rest/api/electronics-item/find-by-category",
						listFilter, ElectronicsItem[].class));

		System.out.println(electronicsItems.size());
		electronicsItems = electronicsItems.subList(
				(pageNumber - 1) * LIMIT > electronicsItems.size() ? electronicsItems.size()
						: ((pageNumber - 1) * LIMIT),
				(pageNumber * LIMIT) > electronicsItems.size() ? electronicsItems.size() : (pageNumber * LIMIT));

		model.addAttribute("electronicsItems", electronicsItems);

		List<Manufacturer> manufacturers = Arrays.asList(
				rest.getForObject("http://localhost:6969/rest/api/manufacturer/find-all", Manufacturer[].class));
		model.addAttribute("manufacturers", manufacturers);

		return "category_electronics";
	}

	@GetMapping("/find-by-manufacturer/{idManufacturer}")
	public String viewElectronicsByManufacturer(@PathVariable String idManufacturer, ModelMap model,
			HttpServletRequest req, HttpServletResponse resp) {

		String price = req.getParameter("price");
		String screendSize = req.getParameter("screendSize");
		String sort = req.getParameter("sort");
		String pageNumber = req.getParameter("page");

		List<FilterMap> listFilter = new ArrayList<>();
		if (idManufacturer != null) {
			FilterMap filter = new FilterMap("idManufacturer", idManufacturer);
			listFilter.add(filter);
		}
		if (price != null) {
			FilterMap filter = new FilterMap("price", price);
			listFilter.add(filter);
			model.addAttribute("price", price);
		}
		if (screendSize != null) {
			FilterMap filter = new FilterMap("screendSize", screendSize);
			listFilter.add(filter);
			model.addAttribute("screendSize", screendSize);
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

		List<ElectronicsItem> electronicsItems = Arrays
				.asList(rest.postForObject("http://localhost:6969/rest/api/electronics-item/find-by-manufacturer",
						listFilter, ElectronicsItem[].class));
		model.addAttribute("electronicsItems", electronicsItems);

		List<Manufacturer> manufacturers = Arrays.asList(
				rest.getForObject("http://localhost:6969/rest/api/manufacturer/find-all", Manufacturer[].class));
		model.addAttribute("manufacturers", manufacturers);

		return "category_electronics";
	}

	@GetMapping("/{slug}")
	public String viewDetail(@PathVariable String slug, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {

		List<ElectronicsItem> sameElectronicsItems = Arrays.asList(rest.getForObject(
				"http://localhost:6969/rest/api/electronics-item/same-item/" + slug, ElectronicsItem[].class));
		model.addAttribute("item_same", sameElectronicsItems);

		ElectronicsItem electronicsItem = rest.getForObject("http://localhost:6969/rest/api/electronics-item/" + slug,
				ElectronicsItem.class);
		model.addAttribute("electronicsItem", electronicsItem);
		return "electronics_detail";
	}
}
