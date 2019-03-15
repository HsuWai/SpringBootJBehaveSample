package com.singtel.voucher.jbehave.story.steps;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.singtel.voucher.entity.Product;

public class CreateProductSteps{
	
	private Product product;
	private int responseCode;
	private String requestUrl;
	
	@Given("url is to create new product api")
	public void givenUrlIsToCreateNewProductApi(){
		 //TODO 
		requestUrl = "http://localhost:8082/api/v2/product";
	}
	
	@When("send post request with product name: <product_name>, description: <product_description> and price: <price>")
	public void givenProduct(	@Named("product_name") String product_name, 
								@Named("product_description") String product_description, 
								@Named("price") String price){
		 //TODO 
		Product request_product = new Product();
		request_product.setProductName(product_name);
		request_product.setProductDescription(product_description);
		request_product.setProductPrice(Double.parseDouble(price));
		//System.out.println("Request .. " + product_name + ", " + product_description + ", " + price );
		HttpEntity<Product> requestEntity = new HttpEntity<Product>(request_product);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product>  productResponse = restTemplate.postForEntity(requestUrl, requestEntity, Product.class);
		responseCode = productResponse.getStatusCodeValue();
		//System.out.println("Response code : " + responseCode);
		product = productResponse.getBody();
	}

	@Then("response status of creation is 201(CREATED)")
	public void thenResponseStatusForCreation(){
		 //TODO 
		Assert.assertTrue(HttpStatus.CREATED.value() == responseCode);
	}
	
	@Then("new product is created successfully with product name: <product_name>, description: <product_description> and price: <price>") 
	public void thenProductIsCreatedSuccessfully(	@Named("product_name") String product_name, 
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