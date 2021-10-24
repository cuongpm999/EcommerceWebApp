package vn.ptit.models.electronics;

import java.util.List;

public class ElectronicsItem {
	private String barCode;
	private double price;
	private double discount;
	private String slug;
	private Electronics electronics;
	private List<ImgElectronicsItem> imgElectronicsItems; 
	
	public ElectronicsItem() {
		// TODO Auto-generated constructor stub
	}

	public ElectronicsItem(String barCode, double price, double discount, String slug, Electronics electronics,
			List<ImgElectronicsItem> imgElectronicsItems) {
		super();
		this.barCode = barCode;
		this.price = price;
		this.discount = discount;
		this.slug = slug;
		this.electronics = electronics;
		this.imgElectronicsItems = imgElectronicsItems;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Electronics getElectronics() {
		return electronics;
	}

	public void setElectronics(Electronics electronics) {
		this.electronics = electronics;
	}

	public List<ImgElectronicsItem> getImgElectronicsItems() {
		return imgElectronicsItems;
	}

	public void setImgElectronicsItems(List<ImgElectronicsItem> imgElectronicsItems) {
		this.imgElectronicsItems = imgElectronicsItems;
	}

}
