package com.singtel.voucher.jbehave.story.steps;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.singtel.voucher.entity.Product;

public class ViewProductSteps{
	
	private Product product;
	private int responseCode;
	private String requestUrl;
	
	@Given("url is to get the product")
	public void givenUrlIsToGetTheProductWithproduct_id(){
		 //TODO 
		requestUrl = "http://localhost:8082/api/v2/product/{id}";
	}
	
	@When("send get request with <product_id>")
	public void whenSendGetRequest( @Named("product_id") String product_id ){
		 //TODO 
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", product_id);
		ResponseEntity<Product> productResponseEntity = restTemplate.getForEntity(requestUrl, Product.class, params);
		responseCode = productResponseEntity.getStatusCodeValue();
		product = productResponseEntity.getBody();
	}
	
	@Then("response status of viewing product is 200")
	public void thenResponseStatusIs200(){
		 //TODO 
		Assert.assertTrue(HttpStatus.OK.value() == responseCode);
	}
	
	@Then("product will be get as response")
	public void thenProductResponse(){
		 //TODO 
		Assert.assertNotNull(product);
	}
}