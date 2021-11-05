package vn.ptit.models.customer;

import java.util.Date;

public class CustomerNew extends Customer{
	private String note;
	public CustomerNew() {
	}
	public CustomerNew(String mobile, String sex, Date dateOfBirth, FullName fullName, Address address, String note) {
		super(mobile, sex, dateOfBirth, fullName, address);
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
