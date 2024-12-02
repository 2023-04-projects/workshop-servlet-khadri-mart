package com.khadri.mart.vegetable.form;

public class VegetableForm {

	private String vegName;
	private int vegQty;
	private double vegPrice;

	public VegetableForm(String vegName, int vegQty, double vegPrice) {
		super();
		this.vegName = vegName;
		this.vegQty = vegQty;
		this.vegPrice = vegPrice;
	}

	public VegetableForm() {

	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public void setVegQty(int vegQty) {
		this.vegQty = vegQty;
	}

	public void setVegPrice(double vegPrice) {
		this.vegPrice = vegPrice;
	}

	public String getVegName() {
		return vegName;
	}

	public int getVegQty() {
		return vegQty;
	}

	public double getVegPrice() {
		return vegPrice;
	}

}
