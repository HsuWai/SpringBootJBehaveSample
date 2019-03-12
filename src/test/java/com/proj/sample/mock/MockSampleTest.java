package com.proj.sample.mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.proj.sample.entity.Product;
import com.proj.sample.service.ProductService;

/**
 * Mockito Test (Simple)
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MockSampleTest {

	@Mock
	private Product product;
	
	@Mock
	private ProductService productService;
		
	@Before
	public void setUp() {
		product = new Product();
		product.setProductName("Test Product");
	}
	
	@Test
	public void testMockCreation() {
		Assert.assertNotNull(product);
		Assert.assertNotNull(productService);
	}
	
	@Test
	public void testGetProductList() {
		List<Product> productList = new ArrayList<Product>();
		Product prod = new Product("Galaxy 10", "Samsung Mobile", 550);
		productList.add(prod);
		when(productService.getAllProducts()).thenReturn(productList);
		Assert.assertSame("Result should be same", productList, productService.getAllProducts());
		verify(productService, times(1)).getAllProducts();
	}
}
