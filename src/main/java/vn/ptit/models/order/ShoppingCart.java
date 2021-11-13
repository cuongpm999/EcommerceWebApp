package vn.ptit.models.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
	private int id;
	private Date dateCreate;
	private double totalAmount;
	private List<LineElectronicsItem> lineElectronicsItems;
	private List<LineBookItem> lineBookItems;
	private List<LineShoesItem> lineShoesItems;
	private List<LineClothesItem> lineClothesItems;
	
	public ShoppingCart() {
		dateCreate = new Date();
		lineBookItems = new ArrayList<LineBookItem>();
		lineClothesItems = new ArrayList<LineClothesItem>();
		lineShoesItems = new ArrayList<LineShoesItem>();
		lineElectronicsItems = new ArrayList<LineElectronicsItem>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<LineElectronicsItem> getLineElectronicsItems() {
		return lineElectronicsItems;
	}

	public void setLineElectronicsItems(List<LineElectronicsItem> lineElectronicsItems) {
		this.lineElectronicsItems = lineElectronicsItems;
	}

	public List<LineBookItem> getLineBookItems() {
		return lineBookItems;
	}

	public void setLineBookItems(List<LineBookItem> lineBookItems) {
		this.lineBookItems = lineBookItems;
	}

	public List<LineShoesItem> getLineShoesItems() {
		return lineShoesItems;
	}

	public void setLineShoesItems(List<LineShoesItem> lineShoesItems) {
		this.lineShoesItems = lineShoesItems;
	}

	public List<LineClothesItem> getLineClothesItems() {
		return lineClothesItems;
	}

	public void setLineClothesItems(List<LineClothesItem> lineClothesItems) {
		this.lineClothesItems = lineClothesItems;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", dateCreate=" + dateCreate + ", totalAmount=" + totalAmount
				+ ", lineElectronicsItems=" + lineElectronicsItems + ", lineBookItems=" + lineBookItems
				+ ", lineShoesItems=" + lineShoesItems + ", lineClothesItems=" + lineClothesItems + "]";
	}

}
