package vn.ptit.model.shoes;

public class Boots extends Shoes {
	private boolean isShoelace;

	public Boots() {
		// TODO Auto-generated constructor stub
	}

	public Boots(int id, String size, String color, String material, String style, String name, boolean isShoelace) {
		super(id, size, color, material, style, name);
		this.isShoelace = isShoelace;
	}

	public boolean getIsShoelace() {
		return isShoelace;
	}

	public void setIsShoelace(boolean isShoelace) {
		this.isShoelace = isShoelace;
	}

}
