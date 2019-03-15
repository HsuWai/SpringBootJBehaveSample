package com.singtel.voucher.jbehave.story.steps;

import java.util.Collections;
import java.util.List;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.singtel.voucher.entity.Product;

public class GetProductListSteps{
	
	private List<Product> productList;
	private String requestUrl;
	private int responseCode;
    
	@Given("url is to get all products")
	public void givenUrlIsToGetAllProducts(){
		 //TODO
		requestUrl = "http://localhost:8082/api/v2/product";
	}
	
	@When("send get request to get all products")
	public void whenSendGetRequestToGetAllProducts() throws Exception{
		 //TODO
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Product>> productListEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {}, Collections.emptyMap() ) ;
		
		responseCode = productListEntity.getStatusCodeValue();
	    if (productListEntity.getStatusCode() == HttpStatus.OK) {
	    	productList = productListEntity.getBody();
	    }
	}
	
	@Then("reponse status of product list is 200")
	public void thenResponseStatusForGettingAllProductsIs200(){
		 //TODO
		Assert.assertTrue(HttpStatus.OK.value() == responseCode);
	}
	
	@Then("successfully get all product list")
	public void thenSuccessfullyGetAllProductList(){
		 //TODO
		Assert.assertNotNull("Response can't be null", productList);
	}
}