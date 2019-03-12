package com.proj.sample.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.proj.sample.entity.Product;
import com.proj.sample.rest.ProductController;
import com.proj.sample.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductServiceControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceControllerTest.class);
	private static final String BASE_URL = "/api/products";
	
	@MockBean
	private ProductService productService;
	
	@Autowired
	private MockMvc mockMvc; //basically an entry point for Server Side test

	static Product mockProduct;
	static List<Product> mockProductList;
	
	@BeforeClass
	public static void setUp() {
		mockProduct = new Product("Laptop", "laptop", 400);
		mockProductList = new ArrayList<Product>();
		mockProductList.add(mockProduct);
	}
	
	@Test
	public void getAllProuctsApiTest() throws Exception {
		log.info("Get product list api testing");
		when(productService.getAllProducts()).thenReturn(mockProductList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/all");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("Result : " + result.getResponse().getContentAsString());
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

}
