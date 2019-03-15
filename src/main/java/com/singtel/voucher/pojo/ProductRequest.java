package com.singtel.voucher.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * POJO for request body (test for swagger documentation)
 *
 */
public class ProductRequest {

	@ApiModelProperty(position = 1, required = true)
	private String productName;
	
	@ApiModelProperty(position = 2, required = true)
	private String productDescription;
	
	@ApiModelProperty(position = 3, required = true)
	private double productPrice;
	
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductRequest(String productName, String productDescription, double productPrice) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
