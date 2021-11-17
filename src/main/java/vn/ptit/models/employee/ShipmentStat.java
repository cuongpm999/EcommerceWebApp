package vn.ptit.models.employee;

import vn.ptit.models.order.Shipment;

public class ShipmentStat extends Shipment {
	private int totalQuantity;

	public ShipmentStat() {
		// TODO Auto-generated constructor stub
	}

	public ShipmentStat(String name, double price, String address, int totalQuantity) {
		super(name, price, address);
		this.totalQuantity = totalQuantity;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}
