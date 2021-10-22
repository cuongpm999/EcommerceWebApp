package vn.ptit.model.electronics;

public class Electronics {
	private int id;
	private String name;
	private String specifications;
	private int warranty;
	private double screendSize;
	private Manufacturer manufacturer;

	public Electronics() {
		// TODO Auto-generated constructor stub
	}

	public Electronics(String name, String specifications, int warranty, double screendSize,
			Manufacturer manufacturer) {
		super();
		this.name = name;
		this.specifications = specifications;
		this.warranty = warranty;
		this.screendSize = screendSize;
		this.manufacturer = manufacturer;
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

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public double getScreendSize() {
		return screendSize;
	}

	public void setScreendSize(double screendSize) {
		this.screendSize = screendSize;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

}
