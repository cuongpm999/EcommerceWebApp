package vn.ptit.models.employee;

public class ItemStat {
	private String barCode;
	private double price;
	private String name;
	private int quantity;
	
	public ItemStat() {
		// TODO Auto-generated constructor stub
	}

	public ItemStat(String barCode, double price, String name, int quantity) {
		super();
		this.barCode = barCode;
		this.price = price;
		this.name = name;
		this.quantity = quantity;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
