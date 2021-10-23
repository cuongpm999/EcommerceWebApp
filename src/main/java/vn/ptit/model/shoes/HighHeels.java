package vn.ptit.model.shoes;

public class HighHeels extends Shoes {
	private double height;

	public HighHeels() {
		// TODO Auto-generated constructor stub
	}

	public HighHeels(int id, String size, String color, String material, String style, String name, double height) {
		super(id, size, color, material, style, name);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
