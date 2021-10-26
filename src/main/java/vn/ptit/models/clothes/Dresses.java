package vn.ptit.models.clothes;

public class Dresses extends Clothes{
	private String size;
	private String length;
	private String pattern;
	
	public Dresses() {
	}
	
	public Dresses(String color, String material, String style, String name, String size, String length, String pattern) {
		super(color, material, style, name);
		this.size = size;
		this.length = length;
		this.pattern = pattern;
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
}
