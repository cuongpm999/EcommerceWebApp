package vn.ptit.utils;

import vn.ptit.models.order.Shipment;
import vn.ptit.models.order.ShoppingCart;

public class PaymentUtil {
	public static double calTotalMoney(ShoppingCart shoppingCart, Shipment shipment) {
		return shoppingCart.getTotalAmount() + shipment.getPrice();
	}
}
