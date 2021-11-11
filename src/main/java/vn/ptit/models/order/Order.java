package vn.ptit.models.order;

import java.util.Date;

import vn.ptit.models.customer.Customer;

public class Order {
	private int id;
	private Date dateCreate;
	private String status;
	private Customer customer;
	private Shipment shipment;
	private ShoppingCart shoppingCart;
	private Payment payment;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(Date dateCreate, String status, Customer customer, Shipment shipment, ShoppingCart shoppingCart,
			Payment payment) {
		super();
		this.dateCreate = dateCreate;
		this.status = status;
		this.customer = customer;
		this.shipment = shipment;
		this.shoppingCart = shoppingCart;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
