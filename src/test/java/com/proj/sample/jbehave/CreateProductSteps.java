package com.proj.sample.jbehave;

import org.jbehave.core.annotations.*;

public class CreateProductSteps{
	
	@Given("url is to create new product api")
	@Pending
	public void givenUrlIsToCreateNewProductApi(){
		 //TODO 
	}
	
	@Given("send post request with product name: <product_name>, description: <product_description> and price: <price>")
	@Pending
	public void givenProduct(@Named("product_name") String product_name, @Named("product_description") String product_description, @Named("price") double price){
		 //TODO 
	}

	@Then("response status of creation is 200")
	@Pending
	public void responseStatusForCreationOfNewProductIs200(){
		 //TODO 
	}
	
	@Then("new product is created successfully with product name: <product_name>, description: <product_description> and price: <price>")
	@Pending public void thenNewProductIsCreatedSuccessfully(String product_name, String product_description, double price){
		//TODO 
	}
}