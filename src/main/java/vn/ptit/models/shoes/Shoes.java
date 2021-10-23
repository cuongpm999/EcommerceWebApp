package vn.ptit.models.shoes;

public class Shoes {
	private int id;

	private String size;

	private String color;

	private String material;

	private String style;

	private String name;

	public Shoes() {
		// TODO Auto-generated constructor stub
	}

	public Shoes(int id, String size, String color, String material, String style, String name) {
		super();
		this.id = id;
		this.size = size;
		this.color = color;
		this.material = material;
		this.style = style;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
