package com.proj.sample.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.proj.sample.entity.Product;
import com.proj.sample.service.ProductService;

/**
 * JUnit testing
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	
	private static final Logger log = LoggerFactory.getLogger(ProductServiceTest.class);

	@Autowired
	ProductService productService;
	
	@Test
	public void getAllProductListTest() {
		log.info("Starting - getAllProductListTest");
		List<Product> productList = productService.getAllProducts();
		Assert.assertNotNull(productList);
		log.info("Success - getAllProductListTest : "+ productList);
	}
	
	@Ignore
	@Test
	public void getProductByIdTest() {
		log.info("Starting - getProductByIdTest");
		Product product = productService.getProductById(2);
		Assert.assertNotNull(product);
		log.info("Success - getProductByIdTest : " + product );
	}
	
	@Ignore
	@Test
	public void getProductByProductNameTest() {
		log.info("Starting - getProductByProductNameTest");
		Product product = productService.getProductByProductName("Iphone");
		Assert.assertNotNull(product);
		log.info("Success - getProductByProductNameTest : " + product );
	}
	
	@Ignore
	@Test
	public void createProductTest() {
		log.info("Starting - createProductTest");
		Product product = new Product("Laptop", "Laptop", 1000);
		product = productService.createProduct(product);
		Assert.assertSame("Product should be created with same name ", "Laptop", product.getProductName());
		log.info("Success - createProductTest : " + product);
	}

	@Ignore
	@Test
	public void editProductTest() {
		log.info("Starting - editProductTest");
		Date date = new Date();
		Timestamp updated_timestamp = new Timestamp(date.getTime());
		Product product = productService.getProductById(2);
		product.setProductName("Wireless Mouse");
		product.setLastModifiedTime(updated_timestamp);
		product = productService.editProduct(product);
		Assert.assertSame("Product's name should be updated : ", "Wireless Mouse", product.getProductName());
		log.info("Success - editProductTest : " + product);
	}
	
	@Ignore
	@Test
	public void deleteProductTest() {
		log.info("Starting - deleteProductTest");
		productService.deleteProduct(1);
		log.info("Success - deleteProductTest");
	}
}
