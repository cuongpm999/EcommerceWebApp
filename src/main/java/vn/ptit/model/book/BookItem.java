package vn.ptit.model.book;

public class BookItem {
	
	private String barCode;

	private double price;

	private double discount;

	public BookItem() {
		super();
	}
	
	public BookItem(double price, double discount, String slug, Book book) {
		super();
		this.price = price;
		this.discount = discount;
		this.slug = slug;
		this.book = book;
	}

	private String slug;

	private Book book;

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
