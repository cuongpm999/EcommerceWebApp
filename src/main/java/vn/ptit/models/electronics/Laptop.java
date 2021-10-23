package vn.ptit.models.electronics;

public class Laptop extends Electronics{
	private String ram;
	private String cpu;
	private String card;
	private String hardDrive;
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String name, String specifications, int warranty, double screendSize, Manufacturer manufacturer,
			String ram, String cpu, String card, String hardDrive) {
		super(name, specifications, warranty, screendSize, manufacturer);
		this.ram = ram;
		this.cpu = cpu;
		this.card = card;
		this.hardDrive = hardDrive;
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

	public String getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}
	
}
