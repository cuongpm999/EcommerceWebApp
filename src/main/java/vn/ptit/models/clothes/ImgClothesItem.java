package vn.ptit.models.clothes;

public class ImgClothesItem {
	private int id;
	private String name;
	private String path;
	private String mine;
	public ImgClothesItem() {
		// TODO Auto-generated constructor stub
	}
	
	public ImgClothesItem(String name, String path, String mine) {
		super();
		this.name = name;
		this.path = path;
		this.mine = mine;
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
	public String getMine() {
		return mine;
	}
	public void setMine(String mine) {
		this.mine = mine;
	}
	
	
}
