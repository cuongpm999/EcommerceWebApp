package vn.ptit.models.order;

import vn.ptit.models.electronics.ElectronicsItem;

public class LineElectronicsItem {
	private int id;
	private ElectronicsItem electronicsItem;
	private int quanity;
	
	public LineElectronicsItem() {
		// TODO Auto-generated constructor stub
	}

	public LineElectronicsItem(ElectronicsItem electronicsItem, int quanity) {
		super();
		this.electronicsItem = electronicsItem;
		this.quanity = quanity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ElectronicsItem getElectronicsItem() {
		return electronicsItem;
	}

	public void setElectronicsItem(ElectronicsItem electronicsItem) {
		this.electronicsItem = electronicsItem;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
}
