package com.singtel.voucher.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.singtel.voucher.entity.Product;
import com.singtel.voucher.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest_old {
	
	private static final Logger log = LoggerFactory.getLogger(ProductControllerTest_old.class);

	@Autowired
    private MockMvc mockMvc;
	
	@InjectMocks
	private ProductController productController;
 
    @Mock
    private ProductService productService;
    
    private Product product;
    private static final String BASE_URL = "api/";
    
    @Before
    public void beforeTest() {
    	Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		product = new Product("Galaxy 10", "Samsung Mobile", 550, ts, ts );
    }
    
	@Test
	public void getAllProducts() throws Exception {
		log.info("Test get all products");
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		log.info("product Service : " + productService);
		when(productService.getAllProducts()).thenReturn(productList);
		
		ResponseEntity<?> productsResult = productController.retrieveAllProducts();
	    List<Product> products = (List<Product>) productsResult.getBody();
	    for(Product p : products) {
	    	log.info(p.toString());
	    }
		//Assert.assertSame("Result should be same", productList, productService.getAllProducts());
		verify(productService, times(1)).getAllProducts();
	}
}
