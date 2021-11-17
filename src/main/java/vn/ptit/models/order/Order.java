package vn.ptit.models.order;

import java.util.Date;

import vn.ptit.models.customer.Customer;

public class Order {
	private int id;
	private Date dateCreate;
	private String status;
	private ShoppingCart shoppingCart;
	private Shipment shipment;
	private Payment payment;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(Date dateCreate, String status, ShoppingCart shoppingCart, Shipment shipment, Payment payment) {
		super();
		this.dateCreate = dateCreate;
		this.status = status;
		this.shoppingCart = shoppingCart;
		this.shipment = shipment;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;

	}
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
