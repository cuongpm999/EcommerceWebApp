package vn.ptit.models.clothes;


public class Jeans extends Clothes{
	
	private String pipe;
	private String size;
	public Jeans() {
		// TODO Auto-generated constructor stub
	}
	
	public Jeans(String color, String material, String style, String name, String pipe, String size) {
		super(color, material, style, name);
		this.pipe = pipe;
		this.size = size;
	}

	public String getPipe() {
		return pipe;
	}
	public void setPipe(String pipe) {
		this.pipe = pipe;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
