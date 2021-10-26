package vn.ptit.models.clothes;

public class Clothes {
	private int id;
	private String color;
	private String material;
	private String style;
	private String name;

	public Clothes() {
	}

	public Clothes(String color, String material, String style, String name) {
		super();
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
