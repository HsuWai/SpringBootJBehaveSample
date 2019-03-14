package com.singtel.voucher.jbehave.story.steps;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.jbehave.core.annotations.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.singtel.voucher.entity.Product;
import com.singtel.voucher.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class GetProductListSteps{
	
	@MockBean
	private ProductService productService;
	
	@Autowired
	private MockMvc mockMvc; //basically an entry point for Server Side test

	private Product mockProduct;
	private List<Product> mockProductList;
	private String requestUrl;
	
	@BeforeStory
	public void setUp() {
		mockProduct = new Product("Laptop", "laptop", 400);
		mockProductList = new ArrayList<Product>();
		mockProductList.add(mockProduct);
	}
    
	@Given("url is to get all products")
	public void givenUrlIsToGetAllProducts(){
		 //TODO
		requestUrl = "/api/products/all";
	}
	
	@When("send get request to get all products")
	public void whenSendGetRequestToGetAllProducts() throws Exception{
		 //TODO
		System.out.println("Send : " + requestUrl);
		when(productService.getAllProducts()).thenReturn(mockProductList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(requestUrl);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("Result : " + result.getResponse().getContentAsString());
	}
	
	@Then("reponse status of product list is 200")
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