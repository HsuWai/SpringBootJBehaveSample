package com.proj.sample.jbehave;
import org.jbehave.core.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proj.sample.entity.Product;

public class CreateNewProductSteps{
	
	private static final Logger log = LoggerFactory.getLogger(CreateNewProductSteps.class);
	private String requestApi;
	private Product product;
	
	@Given("url is to create new product api")
	public void givenUrlIsToCreateNewProductApi(){
		 //TODO 
		requestApi = "/api/products/add";
	}
	
	@Given("product name: <product_name>, description: <product_description> and price: <price>")
	public void givenProduct(@Named("product_name") String product_name, @Named("product_description") String product_description, @Named("price") double price){
		 //TODO 
		System.out.println("GIVEN :" + product_name + "," +product_description+","+price);
		product = new Product();
		product.setProductName(product_name);
		product.setProductDescription(product_description);
		product.setProductPrice(price);
	}
	
	@When("send post request")
	@Pending
	public void whenSendPostRequest(){
		 //TODO 
	}
	

	@Then("response status for creation of new product is 200")
	@Pending
	public void thenResponseStatusForCreationOfNewProductIs200(){
		 //TODO 
	}
	
	@Then("new product is created successfully with product name: <product_name>, description: <product_description> and price: <price>")
	@Pending
	public void thenNewProductIsCreatedSuccessfully(String product_name, String product_description, double price){
		 //TODO 
	}
	
}