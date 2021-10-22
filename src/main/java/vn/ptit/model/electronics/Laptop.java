package vn.ptit.model.electronics;

public class Laptop extends Electronics{
	private String ram;
	private String cpu;
	private String card;
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String name, String specifications, int warranty, double screendSize, Manufacturer manufacturer,
			String ram, String cpu, String card) {
		super(name, specifications, warranty, screendSize, manufacturer);
		this.ram = ram;
		this.cpu = cpu;
		this.card = card;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
}
