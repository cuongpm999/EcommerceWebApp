package vn.ptit.models.book;

public class BookAuthor {
	private int BookID;
	private int AuthorID;
	
	public BookAuthor() {
		super();
	}
	
	public BookAuthor(int bookID, int authorID) {
		super();
		this.BookID = bookID;
		this.AuthorID = authorID;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	
}
