package vn.ptit.controllers.admin.order;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.electronics.Laptop;
import vn.ptit.models.electronics.Manufacturer;
import vn.ptit.models.electronics.Tivi;
import vn.ptit.models.order.Shipment;

@Controller
@RequestMapping("/admin")
public class AdminShipmentController {

	private RestTemplate rest = new RestTemplate();

	@GetMapping("/shipment")
	public String viewShipment(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Shipment> shipments = Arrays
				.asList(rest.getForObject("http://localhost:6969/rest/api/shipment/find-all", Shipment[].class));
		model.addAttribute("shipments", shipments);
		return "admin/order/shipment";
	}

	@GetMapping("/add-shipment")
	public String addShipment(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		model.addAttribute("shipment", new Shipment());
		return "admin/order/add_shipment";
	}

	@PostMapping("/add-shipment")
	public String addShipment(@ModelAttribute("shipment") Shipment shipment, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/shipment/insert", shipment, Shipment.class);
		return "redirect:/admin/shipment";
	}

	@GetMapping("/edit-shipment/{id}")
	public String editShipment(@PathVariable("id") int id, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		Shipment shipment = rest.getForObject("http://localhost:6969/rest/api/shipment/find-one/" + id, Shipment.class);
		model.addAttribute("shipment", shipment);
		return "admin/order/edit_shipment";
	}

	@PostMapping("/edit-shipment")
	public String updateShipment(@ModelAttribute("shipment") Shipment shipment, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		rest.postForObject("http://localhost:6969/rest/api/shipment/insert", shipment, Shipment.class);
		return "redirect:/admin/shipment";
	}

	@GetMapping("/delete-shipment/{id}")
	public String deleteShipment(@PathVariable("id") int id, ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		rest.getForObject("http://localhost:6969/rest/api/shipment/delete-by-id/" + id, Integer.class);
		return "redirect:/admin/shipment";
	}

}
