package vn.ptit.utils;

import vn.ptit.models.customer.CustomerMember;
import vn.ptit.models.customer.CustomerNew;
import vn.ptit.models.order.Cash;
import vn.ptit.models.order.Credit;
import vn.ptit.models.order.DigitalWallet;
import vn.ptit.models.order.Order;

public class HelperOrder {
	private Order order;
	private CustomerMember customerMember;
	private CustomerNew customerNew;
	private Cash cash;
	private Credit credit;
	private DigitalWallet digitalWallet; 
	
	public HelperOrder() {
		// TODO Auto-generated constructor stub
	}

	public HelperOrder(Order order, CustomerMember customerMember, CustomerNew customerNew, Cash cash, Credit credit,
			DigitalWallet digitalWallet) {
		super();
		this.order = order;
		this.customerMember = customerMember;
		this.customerNew = customerNew;
		this.cash = cash;
		this.credit = credit;
		this.digitalWallet = digitalWallet;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public CustomerMember getCustomerMember() {
		return customerMember;
	}

	public void setCustomerMember(CustomerMember customerMember) {
		this.customerMember = customerMember;
	}

	public CustomerNew getCustomerNew() {
		return customerNew;
	}

	public void setCustomerNew(CustomerNew customerNew) {
		this.customerNew = customerNew;
	}

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public DigitalWallet getDigitalWallet() {
		return digitalWallet;
	}

	public void setDigitalWallet(DigitalWallet digitalWallet) {
		this.digitalWallet = digitalWallet;
	}
	
	
}
