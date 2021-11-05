package vn.ptit.models.order;

import vn.ptit.models.electronics.ElectronicsItem;
import vn.ptit.models.shoes.ShoesItem;

public class LineShoesItem {
	private int id;
	private ShoesItem shoesItem;
	private int quanity;
	
	public LineShoesItem() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShoesItem getShoesItem() {
		return shoesItem;
	}

	public void setShoesItem(ShoesItem shoesItem) {
		this.shoesItem = shoesItem;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

}
