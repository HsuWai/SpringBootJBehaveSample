package com.proj.sample.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import com.proj.sample.entity.Product;
import com.proj.sample.service.ProductService;

@SpringBootTest
public class GroupTestProductService extends AbstractTestNGSpringContextTests{

	private static final Logger log = LoggerFactory.getLogger(GroupTestProductService.class);

	@Autowired
	private ProductService productService;
	
	@BeforeGroups("read")
	public void beforeGettingProducts() {
		log.info("Group read - beforeGettingProducts ");
	}
	
	@AfterGroups("read")
	public void afterGettingProducts() {
		log.info("Group read - afterGettingProducts ");
	}

	@BeforeGroups("modify")
	public void beforeModifyingProducts() {
		log.info("Group modify - beforeModifyingProducts ");
	}
	
	@AfterGroups("modify")
	public void afterModifyingProducts() {
		log.info("Group modify - afterModifyingProducts ");
	}
	
	@Test(groups="read")
	public void getAllProductsTest() {
		log.info("Group read - getAllProductsTest");
		List<Product> all_products = productService.getAllProducts();
		log.info("Group read success - getAllProductsTest : "+ all_products);
	}
	
	@Test(groups="read")
	public void getProductByIdTest() {
		log.info("Group read - getProductByIdTest");
		Product product = productService.getProductById(2);
		log.info("Group read success - getAllProductsTest : "+ product);
	}
	
	@Test(groups="modify")
	public void createProductTest() {
		log.info("Group modify - createProductTest");
		Product product = new Product();
		product.setProductName("Mouse");
		product.setProductDescription("Logitech Mouse");
		product.setProductPrice(35.50);
		log.info("Group modify success - editProductTest : "+ product);
	}
	
	@Test(groups="modify")
	public void editProductTest() {
		log.info("Group modify - editProductTest");
		Date date = new Date();
		Timestamp updated_timestamp = new Timestamp(date.getTime());
		Product product = productService.getProductById(2);
		product.setProductDescription("Dell Laptop");
		product.setLastModifiedTime(updated_timestamp);
		log.info("Group modify success - editProductTest : "+ product);
	}
}
