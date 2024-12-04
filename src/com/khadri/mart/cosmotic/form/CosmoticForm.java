package com.khadri.mart.cosmotic.form;

public class CosmoticForm {

	private String category;
	private String name;
	private int qty;
	private double price;

	// Constructor
	public CosmoticForm(String category, String name, int qty, double price) {
		this.category = category;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	// Getter Methods
	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public int getQty() {
		return qty;
	}

	public double getPrice() {
		return price;
	}

}
