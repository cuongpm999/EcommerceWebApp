package vn.ptit.controllers.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import vn.ptit.models.book.Author;
import vn.ptit.models.book.Book;
import vn.ptit.models.book.BookItem;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.clothes.Dresses;
import vn.ptit.models.clothes.Jeans;
import vn.ptit.models.clothes.SwimWear;
import vn.ptit.models.customer.Customer;
import vn.ptit.models.electronics.Electronics;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.electronics.Laptop;
import vn.ptit.models.electronics.MobilePhone;
import vn.ptit.models.electronics.Tivi;
import vn.ptit.models.employee.CustomerStat;
import vn.ptit.models.employee.ItemStat;
import vn.ptit.models.order.Order;
import vn.ptit.models.order.Payment;
import vn.ptit.models.shoes.Boots;
import vn.ptit.models.shoes.HighHeels;
import vn.ptit.models.shoes.Shoes;
import vn.ptit.models.shoes.ShoesItem;
import vn.ptit.models.shoes.Sneaker;
import vn.ptit.services.ItemService;
import vn.ptit.utils.ChartReport;
import vn.ptit.utils.RevenuePerMonth;

@Controller
@RequestMapping("/admin/manage")
public class AdminManageController {
	private RestTemplate rest = new RestTemplate();
	@Autowired
	ItemService itemService;

	@GetMapping
	public String viewManage(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		double totalMoney = rest.getForObject("http://localhost:6969/rest/api/payment/total-revenue", Double.class);
		model.addAttribute("totalMoney", totalMoney);

		int totalCustomer = rest.getForObject("http://localhost:6969/rest/api/customer/total-customers", Integer.class);
		model.addAttribute("totalCustomer", totalCustomer);

		int totalOrder = rest.getForObject("http://localhost:6969/rest/api/order/total-order", Integer.class);
		model.addAttribute("totalOrder", totalOrder);

		int totalVisit = rest.getForObject("http://localhost:6969/rest/api/statistic/total-visit", Integer.class);
		model.addAttribute("totalVisit", totalVisit);

		String label[] = new String[6];
		double data[] = new double[6];
		List<Order> orders = Arrays.asList(
				rest.getForObject("http://localhost:6969/rest/api/order/find-by-status-success", Order[].class));
		label[0] = RevenuePerMonth.getStringMonth5();
		label[1] = RevenuePerMonth.getStringMonth4();
		label[2] = RevenuePerMonth.getStringMonth3();
		label[3] = RevenuePerMonth.getStringMonth2();
		label[4] = RevenuePerMonth.getStringMonth1();
		label[5] = RevenuePerMonth.getStringMonth();

		data[0] = RevenuePerMonth.getTotalMoneyMonth5(orders);
		data[1] = RevenuePerMonth.getTotalMoneyMonth4(orders);
		data[2] = RevenuePerMonth.getTotalMoneyMonth3(orders);
		data[3] = RevenuePerMonth.getTotalMoneyMonth2(orders);
		data[4] = RevenuePerMonth.getTotalMoneyMonth1(orders);
		data[5] = RevenuePerMonth.getTotalMoneyMonth(orders);

		model.addAttribute("chartReport", new ChartReport(label, data));

		List<ItemStat> itemStats = itemService.statItemBestSeller(orders);
		model.addAttribute("itemStats", itemStats);
		return "admin/manage";
	}
	
	@GetMapping("/statistic/item")
	public String viewItemStat(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Order> orders = Arrays.asList(rest.getForObject("http://localhost:6969/rest/api/order/find-by-status-success", Order[].class));
		List<ItemStat> itemStats = itemService.statItemBestSeller(orders);
		model.addAttribute("itemStats", itemStats);
		return "admin/itemstat";
	}

	@GetMapping("/statistic/customer")
	public String viewCustomerStatistic(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		List<Customer> customers = Arrays.asList(
				rest.getForObject("http://localhost:6969/rest/api/customer/find-all-customer", Customer[].class));
		List<CustomerStat> customerStats = new ArrayList<CustomerStat>();
		for (int i = 0; i < customers.size(); i++) {
			double total = 0;
			List<Order> ordersByCustomer = Arrays.asList(rest.getForObject(
					"http://localhost:6969/rest/api/order/get-order-success-by-customer/" + customers.get(i).getId(),
					Order[].class));
			if (ordersByCustomer.size() > 0) {
				for (int j = 0; j < ordersByCustomer.size(); j++) {
					total += ordersByCustomer.get(j).getPayment().getTotalMoney();
				}
				customerStats.add(new CustomerStat(customers.get(i).getMobile(), customers.get(i).getSex(),
						customers.get(i).getDateOfBirth(), customers.get(i).getFullName(),
						customers.get(i).getAddress(), customers.get(i).getEmail(), total));
			}
		}
		Collections.sort(customerStats, new Comparator<CustomerStat>() {
			@Override
			public int compare(CustomerStat o1, CustomerStat o2) {
				return (int) (o2.getTotal() - o1.getTotal());
			}

		});
		model.addAttribute("customerStats", customerStats);
		return "admin/customerstat";
	}

}
