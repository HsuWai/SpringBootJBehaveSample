package com.proj.sample.jbehave;
import org.jbehave.core.annotations.*;
public class GetProductListSteps{
	
	private String requestUrl;
	
	
	@Given("url is to get all products")
	public void givenUrlIsToGetAllProducts(){
		 //TODO 
		requestUrl = "/api/products/all";
	}
	
	@When("send get request to get all products")
	@Pending
	public void whenSendGetRequestToGetAllProducts(){
		 //TODO 
	}
	
	@Then("response status for getting all products is 200")
	@Pending
	public void thenResponseStatusForGettingAllProductsIs200(){
		 //TODO 
	}
	
	@Then("successfully get all product list")
	@Pending
	public void thenSuccessfullyGetAllProductList(){
		 //TODO 
	}
}