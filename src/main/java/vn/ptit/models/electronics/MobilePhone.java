package vn.ptit.models.electronics;

public class MobilePhone extends Electronics{
	private String ram;
	private String cpu;
	private double camera;
	
	public MobilePhone() {
		// TODO Auto-generated constructor stub
	}
	
	public MobilePhone(String name, String specifications, int warranty, double screendSize, Manufacturer manufacturer,
			String ram, String cpu, double camera) {
		super(name, specifications, warranty, screendSize, manufacturer);
		this.ram = ram;
		this.cpu = cpu;
		this.camera = camera;
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

	public double getCamera() {
		return camera;
	}

	public void setCamera(double camera) {
		this.camera = camera;
	}
	
}
