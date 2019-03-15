package com.singtel.voucher.jbehave.story.steps;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DeleteProductSteps{
	
	private int responseCode;
	private String requestUrl;
	
	@Given("url is to delete the product")
	public void givenUrlIsToDeleteTheProductWithproduct_id(){
		 //TODO 
		requestUrl = "http://localhost:8082/api/v2/product/{id}";
	}
	
	@When("send delete request to delete with product_id <product_id>")
	public void whenSendGetRequestToDelete(@Named("product_id") String product_id){
		 //TODO 
		Map<String,String> request_params = new HashMap<String,String>();
		request_params.put("id", product_id);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String>  productResponse = restTemplate.exchange(requestUrl, HttpMethod.DELETE, null, String.class, request_params);
		responseCode = productResponse.getStatusCodeValue();	
	}
	
	@Then("response status of deletion is 200")
	public void thenResponseStatusOfDeletionIs200(){
		 //TODO 
		Assert.assertTrue( HttpStatus.OK.value() == responseCode);
	}
	
}