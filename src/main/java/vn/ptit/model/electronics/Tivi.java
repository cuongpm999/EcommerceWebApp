package vn.ptit.model.electronics;

public class Tivi extends Electronics{
	private String connector;

	public Tivi() {
		// TODO Auto-generated constructor stub
	}
	
	public Tivi(String name, String specifications, int warranty, double screendSize, Manufacturer manufacturer,
			String connector) {
		super(name, specifications, warranty, screendSize, manufacturer);
		this.connector = connector;
	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}
	
}
