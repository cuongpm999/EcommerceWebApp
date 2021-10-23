package vn.ptit.model.book;

public class Author {

	private int id;
	
	private String name;
	
	private String biography;
	
	public Author() {
		super();
	}
	
	public Author(String name, String biography) {
		super();
		this.name = name;
		this.biography = biography;
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	
}
