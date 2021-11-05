package vn.ptit.models.customer;

import java.util.Date;

public class CustomerMember extends Customer{
	private double point;
	private Account account;
	
	public CustomerMember() {
	}

	public CustomerMember(String mobile, String sex, Date dateOfBirth, FullName fullName, Address address, double point,
			Account account) {
		super(mobile, sex, dateOfBirth, fullName, address);
		this.point = point;
		this.account = account;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
