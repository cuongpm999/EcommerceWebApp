package vn.ptit.models.employee;

import java.util.Date;

import vn.ptit.models.customer.Address;
import vn.ptit.models.customer.Customer;
import vn.ptit.models.customer.FullName;

public class CustomerStat extends Customer{
	private double total;

	public CustomerStat() {
		super();
	}
	
	public CustomerStat(String mobile, String sex, Date dateOfBirth, FullName fullName, Address address, String email,
			double total) {
		super(mobile, sex, dateOfBirth, fullName, address, email);
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
