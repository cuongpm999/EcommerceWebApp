package vn.ptit.models.shoes;

public class Sneaker extends Shoes {
	private boolean clinch;
	private String sole;

	public Sneaker() {
		// TODO Auto-generated constructor stub
	}

	public Sneaker(int id, String size, String color, String material, String style, String name, boolean clinch,
			String sole) {
		super(id, size, color, material, style, name);
		this.clinch = clinch;
		this.sole = sole;
	}

	public boolean isClinch() {
		return clinch;
	}

	public void setClinch(boolean clinch) {
		this.clinch = clinch;
	}

	public String getSole() {
		return sole;
	}

	public void setSole(String sole) {
		this.sole = sole;
	}

}
