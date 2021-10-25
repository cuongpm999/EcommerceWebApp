package vn.ptit.models.shoes;

import java.util.List;

public class ShoesItem {
	private String barCode;
	private double price;
	private double discount;
	private String slug;
	private Shoes shoes;
	private List<ImgShoesItem> imgShoesItems;
	public ShoesItem() {
		// TODO Auto-generated constructor stub
	}
	public ShoesItem(String barCode, double price, double discount, String slug, Shoes shoes,
			List<ImgShoesItem> imgShoesItems) {
		super();
		this.barCode = barCode;
		this.price = price;
		this.discount = discount;
		this.slug = slug;
		this.shoes = shoes;
		this.imgShoesItems = imgShoesItems;
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
	public Shoes getShoes() {
		return shoes;
	}
	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}
	public List<ImgShoesItem> getImgShoesItems() {
		return imgShoesItems;
	}
	public void setImgShoesItems(List<ImgShoesItem> imgShoesItems) {
		this.imgShoesItems = imgShoesItems;
	}
	
}
