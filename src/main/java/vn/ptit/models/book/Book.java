package vn.ptit.models.book;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;

	private String title;

	private String summary;

	private int pages;

	private String language;
	
	private Publisher publisher;

	private List<Author> authors = new ArrayList<>();
	
	public Book() {
		super();
	}

	public Book(String title, String summary, int pages, String language, Publisher publisher, List<Author> authors) {
		super();
		this.title = title;
		this.summary = summary;
		this.pages = pages;
		this.language = language;
		this.publisher = publisher;
		this.authors = authors;
	}

	

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}
