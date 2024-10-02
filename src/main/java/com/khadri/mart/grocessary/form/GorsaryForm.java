package com.khadri.mart.grocessary.form;

public class GorsaryForm {

	private String grosaryName;
	private int grosaryQty;
	private Double grosaryPrice;

	public GorsaryForm(String grosaryName, int grosaryQty, Double grosaryPrice) {
		super();
		this.grosaryName = grosaryName;
		this.grosaryQty = grosaryQty;
		this.grosaryPrice = grosaryPrice;
	}

	public String getGrosaryName() {
		return grosaryName;
	}

	public int getGrosaryQty() {
		return grosaryQty;
	}

	public Double getGrosaryPrice() {
		return grosaryPrice;
	}

}
