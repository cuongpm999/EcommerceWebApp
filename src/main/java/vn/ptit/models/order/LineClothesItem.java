package vn.ptit.models.order;

import vn.ptit.models.clothes.ClothesItem;
import vn.ptit.models.electronics.ElectronicsItem;

public class LineClothesItem {
	private int id;
	private ClothesItem clothesItem;
	private int quanity;
	
	public LineClothesItem() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClothesItem getClothesItem() {
		return clothesItem;
	}

	public void setClothesItem(ClothesItem clothesItem) {
		this.clothesItem = clothesItem;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

}
