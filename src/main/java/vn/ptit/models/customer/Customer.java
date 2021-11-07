package vn.ptit.models.customer;

import java.util.Date;

public class Customer {
	private int id;
	private String mobile;
	private String sex;
	private Date dateOfBirth;
	private FullName fullName;
	private Address address;
	private String email;
	
	public Customer() {
	}

	public Customer(String mobile, String sex, Date dateOfBirth, FullName fullName, Address address) {
		super();
		this.mobile = mobile;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.fullName = fullName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
