package vn.ptit.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vn.ptit.models.book.BookItem;
import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.order.LineBookItem;
import vn.ptit.models.order.LineClothesItem;
import vn.ptit.models.order.LineElectronicsItem;
import vn.ptit.models.order.LineShoesItem;
import vn.ptit.models.order.ShoppingCart;
import vn.ptit.models.shoes.ShoesItem;

public class CartUtil {
	public static void addToCart(ElectronicsItem electronicsItem, HttpServletRequest request) {
		String slug = electronicsItem.getSlug();
		List<LineElectronicsItem> lineElectronicsItems = new ArrayList<>();
		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		lineElectronicsItems = shoppingCart.getLineElectronicsItems();

		boolean isExists = false;
		for (LineElectronicsItem item : lineElectronicsItems) {
			if (item.getElectronicsItem().getSlug().equalsIgnoreCase(slug)) {
				isExists = true;
				break;
			}
		}

		if (!isExists) {
			LineElectronicsItem item = new LineElectronicsItem();
			item.setElectronicsItem(electronicsItem);
			item.setQuanity(1);
			lineElectronicsItems.add(item);
		} else {
			for (LineElectronicsItem item : lineElectronicsItems) {
				if (item.getElectronicsItem().getSlug().equalsIgnoreCase(slug)) {
					item.setQuanity(item.getQuanity() + 1);
					break;
				}
			}
		}

		shoppingCart.setLineElectronicsItems(lineElectronicsItems);

		httpSession.setAttribute("status", null);
		httpSession.setAttribute("cart", shoppingCart);

	}

	public static void addToCart(BookItem bookItem, HttpServletRequest request) {
		String slug = bookItem.getSlug();
		List<LineBookItem> lineBookItems = new ArrayList<>();
		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		lineBookItems = shoppingCart.getLineBookItems();

		boolean isExists = false;
		for (LineBookItem item : lineBookItems) {
			if (item.getBookItem().getSlug().equalsIgnoreCase(slug)) {
				isExists = true;
				break;
			}
		}

		if (!isExists) {
			LineBookItem item = new LineBookItem();
			item.setBookItem(bookItem);
			item.setQuanity(1);
			lineBookItems.add(item);
		} else {
			for (LineBookItem item : lineBookItems) {
				if (item.getBookItem().getSlug().equalsIgnoreCase(slug)) {
					item.setQuanity(item.getQuanity() + 1);
					break;
				}
			}
		}

		shoppingCart.setLineBookItems(lineBookItems);

		httpSession.setAttribute("status", null);
		httpSession.setAttribute("cart", shoppingCart);

	}

	public static void addToCart(ClothesItem clothesItem, HttpServletRequest request) {
		String slug = clothesItem.getSlug();
		List<LineClothesItem> lineClothesItems = new ArrayList<>();
		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		lineClothesItems = shoppingCart.getLineClothesItems();

		boolean isExists = false;
		for (LineClothesItem item : lineClothesItems) {
			if (item.getClothesItem().getSlug().equalsIgnoreCase(slug)) {
				isExists = true;
				break;
			}
		}

		if (!isExists) {
			LineClothesItem item = new LineClothesItem();
			item.setClothesItem(clothesItem);
			item.setQuanity(1);
			lineClothesItems.add(item);
		} else {
			for (LineClothesItem item : lineClothesItems) {
				if (item.getClothesItem().getSlug().equalsIgnoreCase(slug)) {
					item.setQuanity(item.getQuanity() + 1);
					break;
				}
			}
		}

		shoppingCart.setLineClothesItems(lineClothesItems);

		httpSession.setAttribute("status", null);
		httpSession.setAttribute("cart", shoppingCart);

	}

	public static void addToCart(ShoesItem shoesItem, HttpServletRequest request) {
		String slug = shoesItem.getSlug();
		List<LineShoesItem> lineShoesItems = new ArrayList<>();
		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		lineShoesItems = shoppingCart.getLineShoesItems();

		boolean isExists = false;
		for (LineShoesItem item : lineShoesItems) {
			if (item.getShoesItem().getSlug().equalsIgnoreCase(slug)) {
				isExists = true;
				break;
			}
		}

		if (!isExists) {
			LineShoesItem item = new LineShoesItem();
			item.setShoesItem(shoesItem);
			item.setQuanity(1);
			lineShoesItems.add(item);
		} else {
			for (LineShoesItem item : lineShoesItems) {
				if (item.getShoesItem().getSlug().equalsIgnoreCase(slug)) {
					item.setQuanity(item.getQuanity() + 1);
					break;
				}
			}
		}

		shoppingCart.setLineShoesItems(lineShoesItems);

		httpSession.setAttribute("status", null);
		httpSession.setAttribute("cart", shoppingCart);

	}

	public static void tinhSoLuongMua(HttpServletRequest request) {
		List<LineElectronicsItem> lineElectronicsItems = new ArrayList<>();
		List<LineBookItem> lineBookItems = new ArrayList<>();
		List<LineClothesItem> lineClothesItems = new ArrayList<>();
		List<LineShoesItem> lineShoesItems = new ArrayList<>();

		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		lineElectronicsItems = shoppingCart.getLineElectronicsItems();
		lineBookItems = shoppingCart.getLineBookItems();
		lineClothesItems = shoppingCart.getLineClothesItems();
		lineShoesItems = shoppingCart.getLineShoesItems();

		int soLuongMua = 0;
		for (LineElectronicsItem item : lineElectronicsItems) {
			soLuongMua += item.getQuanity();
		}
		for (LineBookItem item : lineBookItems) {
			soLuongMua += item.getQuanity();
		}
		for (LineClothesItem item : lineClothesItems) {
			soLuongMua += item.getQuanity();
		}
		for (LineShoesItem item : lineShoesItems) {
			soLuongMua += item.getQuanity();
		}

		httpSession.setAttribute("soLuongMua", soLuongMua);

	}

	public static void tinhTongTien(HttpServletRequest request) {
		List<LineElectronicsItem> lineElectronicsItems = new ArrayList<>();
		List<LineBookItem> lineBookItems = new ArrayList<>();
		List<LineClothesItem> lineClothesItems = new ArrayList<>();
		List<LineShoesItem> lineShoesItems = new ArrayList<>();

		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}

		lineElectronicsItems = shoppingCart.getLineElectronicsItems();
		lineBookItems = shoppingCart.getLineBookItems();
		lineClothesItems = shoppingCart.getLineClothesItems();
		lineShoesItems = shoppingCart.getLineShoesItems();

		double t = 0;
		for (LineElectronicsItem item : lineElectronicsItems) {
			t += item.getQuanity()
					* (item.getElectronicsItem().getPrice() * (100 - item.getElectronicsItem().getDiscount()) / 100);
		}
		for (LineBookItem item : lineBookItems) {
			t += item.getQuanity() * (item.getBookItem().getPrice() * (100 - item.getBookItem().getDiscount()) / 100);
		}
		for (LineClothesItem item : lineClothesItems) {
			t += item.getQuanity()
					* (item.getClothesItem().getPrice() * (100 - item.getClothesItem().getDiscount()) / 100);
		}
		for (LineShoesItem item : lineShoesItems) {
			t += item.getQuanity() * (item.getShoesItem().getPrice() * (100 - item.getShoesItem().getDiscount()) / 100);
		}

		shoppingCart.setTotalAmount(t);

	}

	public static void editCart(String slug, String quantity, String category, HttpServletRequest request) {
		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}
		
		if(category.equalsIgnoreCase("electronics")) {
			for (int i = 0; i < shoppingCart.getLineElectronicsItems().size(); i++) {
				if(shoppingCart.getLineElectronicsItems().get(i).getElectronicsItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineElectronicsItems().get(i).setQuanity(Integer.parseInt(quantity));
				}
			}
		}
		
		if(category.equalsIgnoreCase("book")) {
			for (int i = 0; i < shoppingCart.getLineBookItems().size(); i++) {
				if(shoppingCart.getLineBookItems().get(i).getBookItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineBookItems().get(i).setQuanity(Integer.parseInt(quantity));
				}
			}
		}
		
		if(category.equalsIgnoreCase("shoes")) {
			for (int i = 0; i < shoppingCart.getLineShoesItems().size(); i++) {
				if(shoppingCart.getLineShoesItems().get(i).getShoesItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineShoesItems().get(i).setQuanity(Integer.parseInt(quantity));
				}
			}
		}
		
		if(category.equalsIgnoreCase("clothes")) {
			for (int i = 0; i < shoppingCart.getLineClothesItems().size(); i++) {
				if(shoppingCart.getLineClothesItems().get(i).getClothesItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineClothesItems().get(i).setQuanity(Integer.parseInt(quantity));
				}
			}
		}

		httpSession.setAttribute("status", null);
		httpSession.setAttribute("cart", shoppingCart);
	}
	
	public static void deleteCart(String slug, String category, HttpServletRequest request) {
		ShoppingCart shoppingCart = new ShoppingCart();
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("cart") != null) {
			shoppingCart = ((ShoppingCart) httpSession.getAttribute("cart"));
		}
		
		if(category.equalsIgnoreCase("electronics")) {
			for (int i = 0; i < shoppingCart.getLineElectronicsItems().size(); i++) {
				if(shoppingCart.getLineElectronicsItems().get(i).getElectronicsItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineElectronicsItems().remove(i);
				}
			}
		}
		
		if(category.equalsIgnoreCase("book")) {
			for (int i = 0; i < shoppingCart.getLineBookItems().size(); i++) {
				if(shoppingCart.getLineBookItems().get(i).getBookItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineBookItems().remove(i);
				}
			}
		}
		
		if(category.equalsIgnoreCase("shoes")) {
			for (int i = 0; i < shoppingCart.getLineShoesItems().size(); i++) {
				if(shoppingCart.getLineShoesItems().get(i).getShoesItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineShoesItems().remove(i);
				}
			}
		}
		
		if(category.equalsIgnoreCase("clothes")) {
			for (int i = 0; i < shoppingCart.getLineClothesItems().size(); i++) {
				if(shoppingCart.getLineClothesItems().get(i).getClothesItem().getSlug().equalsIgnoreCase(slug)) {
					shoppingCart.getLineClothesItems().remove(i);
				}
			}
		}

		httpSession.setAttribute("status", null);
		httpSession.setAttribute("cart", shoppingCart);
	}

}
