package vn.ptit.models.shoes;

public class ImgShoesItem {
	private int id;
	private String name;
	private String path;
	private String mime;
	public ImgShoesItem() {
		// TODO Auto-generated constructor stub
	}
	public ImgShoesItem(String name, String path, String mime) {
		super();
		this.name = name;
		this.path = path;
		this.mime = mime;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	
}
