package vn.ptit.model.electronics;

public class Manufacturer {
	private int id;
	private String name;
	private String address;

	public Manufacturer(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Manufacturer() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
