package vn.ptit.models.order;

import vn.ptit.models.book.BookItem;
import vn.ptit.models.electronics.ElectronicsItem;

public class LineBookItem {
	private int id;
	private BookItem bookItem;
	private int quanity;
	
	public LineBookItem() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookItem getBookItem() {
		return bookItem;
	}

	public void setBookItem(BookItem bookItem) {
		this.bookItem = bookItem;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

}
