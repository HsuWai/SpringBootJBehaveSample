package com.singtel.voucher.jbehave.story.steps;

import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.singtel.voucher.entity.Product;

public class EditProductSteps{
	
	private int responseCode;
	private String requestUrl;
	private Product product;
	
	@Given("url is to edit the product")
	public void editTheProductWithproduct_id(){
		 //TODO 
		requestUrl = "http://localhost:8082/api/v2/product/{id}";
	}
	
	@When("send put request with product_id <product_id>, product name: <product_name>, description: <product_description> and price: <price>")
	public void sendPostRequest(@Named("product_id") String product_id,
								@Named("product_name") String product_name, 
								@Named("product_description") String product_description, 
								@Named("price") String price){
		 //TODO 
		Map<String,String> request_params = new HashMap<String,String>();
		request_params.put("id", product_id);
		
		Product request_product = new Product();
		request_product.setProductName(product_name);
		request_product.setProductDescription(product_description);
		request_product.setProductPrice(Double.parseDouble(price));
		
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(request_product);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product>  productResponse = restTemplate.exchange(requestUrl, HttpMethod.PUT, requestEntity, Product.class, request_params);
		
		responseCode = productResponse.getStatusCodeValue();
		product = productResponse.getBody();
	}
	
	@Then("response status for editing product is 200")
	public void responseStatusForEditingProductIs200(){
		 //TODO 
		Assert.assertTrue(HttpStatus.OK.value() == responseCode);
	}
	
	@Then("the product will be updated with product name: <product_name>, description: <product_description> and price: <price>")
	public void thenProductWillBeUpdated(	@Named("product_name") String product_name, 
											@Named("product_description") String product_description, 
											@Named("price") String price){
		 //TODO
		System.out.println("THEN " + product_name + ", " + product_description + ", " + price);
		Assert.assertNotNull(product);
		Assert.assertEquals("Prodcut must be created with the same name", product_name, product.getProductName());
		Assert.assertEquals("Prodcut must be created with the same description", product_description, product.getProductDescription());
		Assert.assertEquals(Double.parseDouble(price), product.getProductPrice(), 0.001);
	}
}