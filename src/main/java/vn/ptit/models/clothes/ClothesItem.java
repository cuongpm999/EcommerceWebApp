package vn.ptit.models.clothes;

import java.util.List;

public class ClothesItem {
	private String barCode;
	private double price;
	private double discount;
	private String slug;
	private Clothes clothes;
	private List<ImgClothesItem> imgClothesItems;
	public ClothesItem() {
		// TODO Auto-generated constructor stub
	}
	
	public ClothesItem(String barCode, double price, double discount, String slug, Clothes clothes,
			List<ImgClothesItem> imgClothesItems) {
		super();
		this.barCode = barCode;
		this.price = price;
		this.discount = discount;
		this.slug = slug;
		this.clothes = clothes;
		this.imgClothesItems = imgClothesItems;
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
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	public List<ImgClothesItem> getImgClothesItems() {
		return imgClothesItems;
	}
	public void setImgClothesItems(List<ImgClothesItem> imgClothesItems) {
		this.imgClothesItems = imgClothesItems;
	}
}
