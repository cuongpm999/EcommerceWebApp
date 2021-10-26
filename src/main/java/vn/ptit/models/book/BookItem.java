package vn.ptit.models.book;

import java.util.List;

public class BookItem {
	private String barCode;
	private double price;
	private double discount;
	private String slug;
	private Book book;
	private List<ImgBookItem> imgBookItems;

	public BookItem() {
		super();
	}

	public List<ImgBookItem> getImgBookItems() {
		return imgBookItems;
	}

	public void setImgBookItems(List<ImgBookItem> imgBookItems) {
		this.imgBookItems = imgBookItems;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
