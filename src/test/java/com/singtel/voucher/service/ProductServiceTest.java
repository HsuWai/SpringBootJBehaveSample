package com.singtel.voucher.service;

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

import com.singtel.voucher.entity.Product;
import com.singtel.voucher.service.ProductService;

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
	
	
	@Test
	public void getProductByIdTest() {
		log.info("Starting - getProductByIdTest");
		Product get_product = productService.getProductById(3);
		Assert.assertNotNull(get_product);
		log.info("Success - getProductByIdTest : " + get_product );
	}
	
	@Ignore
	@Test
	public void createProductTest() {
		log.info("Starting - createProductTest");
		Product new_product = new Product("Adapter", "Adapter", 30.50);
		new_product = productService.createProduct(new_product);
		Assert.assertSame("Product should be created with same name ", "Adapter", new_product.getProductName());
		log.info("Success - createProductTest : " + new_product);
	}

	@Ignore
	@Test
	public void editProductTest() {
		log.info("Starting - editProductTest");
		Date date = new Date();
		Timestamp updated_timestamp = new Timestamp(date.getTime());
		Product edit_product = productService.getProductById(4);
		edit_product.setProductName("Wireless Mouse");
		edit_product.setLastModifiedTime(updated_timestamp);
		edit_product = productService.editProduct(edit_product);
		Assert.assertSame("Product's name should be updated : ", "Wireless Mouse", edit_product.getProductName());
		log.info("Success - editProductTest : " + edit_product);
	}
	
	@Ignore
	@Test
	public void deleteProductTest() {
		log.info("Starting - deleteProductTest");
		productService.deleteProduct(10);
		log.info("Success - deleteProductTest");
	}
}
