package com.singtel.voucher.controller;

import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import com.singtel.voucher.entity.Product;
import com.singtel.voucher.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(ProductControllerTest.class);
	private static final String BASE_URL = "/api/product";
	
	@MockBean
	private ProductService productService;
	
	@Autowired
	private MockMvc mockMvc; //basically an entry point for Server Side test
	
	Product mockProduct;
	List<Product> mockProductList;
	Map<String, String> request_map;
	
	@Before
	public void setUp() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		mockProduct = new Product("Laptop", "laptop", 400, ts, ts);
		mockProductList = new ArrayList<Product>();
		mockProductList.add(mockProduct);
		
		request_map = new HashMap<String, String>();
		request_map.put("productName", "HP Backbag");
		request_map.put("productDescription", "backbag");
		request_map.put("productPrice", "78.40");
	}
	
	@Ignore
	@Test
	public void getAllProuctsApiTest() throws Exception {
		log.info("Get product list api testing");
		
		when(productService.getAllProducts()).thenReturn(mockProductList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        log.info("Result : " + result.getResponse().getContentAsString());
        
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        Assert.assertNotNull(result.getResponse());
	}
	
	@Ignore
	@Test
	public void getProductByIdApiTest() throws Exception {
		log.info("Get product by id api testing");
		
		when(productService.getProductById(Mockito.anyInt())).thenReturn(mockProduct);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_URL + "/2");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        log.info("Result : " + result.getResponse().getContentAsString());
        
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        Assert.assertNotNull(result.getResponse());
	}
	
	@Ignore
	@Test
	public void createProductApiTest() throws Exception {
		log.info("Create product api testing");
		
		when(productService.createProduct(Mockito.any(Product.class))).thenReturn(mockProduct);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(request_map);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL).content(json).contentType("application/json");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		Assert.assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
		Assert.assertNotNull(result.getResponse());
	}

	@Test
	public void editProductApiTest() throws Exception {
		log.info("Edit product api testing");
		
		when(productService.editProduct(Mockito.any(Product.class))).thenReturn(mockProduct);
		when(productService.getProductById(Mockito.anyInt())).thenReturn(mockProduct);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(request_map);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(BASE_URL+"/4").content(json).contentType("application/json");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Assert.assertNotNull(result.getResponse());
	}
	
	@Test
	public void deleteProductApiTest() throws Exception {
		log.info("Delete product api testing");
		
		when(productService.getProductById(Mockito.anyInt())).thenReturn(mockProduct);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(BASE_URL+"/4");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		log.info("Result : " + result.getResponse().getContentAsString());
        
		Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		Assert.assertNotNull(result.getResponse());
	}
}
