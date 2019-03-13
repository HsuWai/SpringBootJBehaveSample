package com.proj.sample.request;

public class ProductRequest {

	private int id;
	private String productName;
	private String prouductDescription;
	private double productPrice;
	
	public ProductRequest(String productName, String prouductDescription, double productPrice) {
		super();
		this.productName = productName;
		this.prouductDescription = prouductDescription;
		this.productPrice = productPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProuductDescription() {
		return prouductDescription;
	}

	public void setProuductDescription(String prouductDescription) {
		this.prouductDescription = prouductDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
