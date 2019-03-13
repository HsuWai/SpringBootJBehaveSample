package com.proj.sample.jbehave;
import org.jbehave.core.annotations.*;

public class EditProductSteps{
	
	@Given("url is to edit the product with <product_id>")
	@Pending
	public void editTheProductWithproduct_id(@Named("product_id") String product_id){
		 //TODO 
	}
	
	@When("send post request with product name: <product_name>, description: <product_description> and price: <price>")
	@Pending
	public void sendPostRequest(
			@Named("product_name") String product_name, @Named("product_description") String product_description, @Named("price") String price){
		 //TODO 
	}
	
	@Then("response status for editing product is 200")
	@Pending
	public void responseStatusForEditingProductIs200(){
		 //TODO 
	}
	
	@Then("the product will be updated with product name: <product_name>, description: <product_description> and price: <price>")
	@Pending
	public void theProductWillBeUpdated(
			@Named("product_name") String product_name, @Named("product_description") String product_description, @Named("price") String price){
		 //TODO 
	}
}