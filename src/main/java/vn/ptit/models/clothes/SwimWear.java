package vn.ptit.models.clothes;

public class SwimWear extends Clothes {
	private int bustSize;
	private int waistSize;
	private int hipsSize;

	public SwimWear() {
		// TODO Auto-generated constructor stub
	}

	public SwimWear(String color, String material, String style, String name, int bustSize, int waistSize,
			int hipsSize) {
		super(color, material, style, name);
		this.bustSize = bustSize;
		this.waistSize = waistSize;
		this.hipsSize = hipsSize;
	}

	public int getBustSize() {
		return bustSize;
	}

	public void setBustSize(int bustSize) {
		this.bustSize = bustSize;
	}

	public int getWaistSize() {
		return waistSize;
	}

	public void setWaistSize(int waistSize) {
		this.waistSize = waistSize;
	}

	public int getHipsSize() {
		return hipsSize;
	}

	public void setHipsSize(int hipsSize) {
		this.hipsSize = hipsSize;
	}

}
