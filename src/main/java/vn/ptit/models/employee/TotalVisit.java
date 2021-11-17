package vn.ptit.models.employee;

import java.util.Date;

public class TotalVisit {
	private int id;
	private String ipAddress;
	private Date dateVisited;
	
	public TotalVisit() {
		// TODO Auto-generated constructor stub
	}

	public TotalVisit(String ipAddress, Date dateVisited) {
		super();
		this.ipAddress = ipAddress;
		this.dateVisited = dateVisited;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getDateVisited() {
		return dateVisited;
	}

	public void setDateVisited(Date dateVisited) {
		this.dateVisited = dateVisited;
	}

}
