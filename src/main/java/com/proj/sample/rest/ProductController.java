package com.proj.sample.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proj.sample.entity.Product;
import com.proj.sample.service.ProductService;

/**
 * Controller for api request
 *
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> retrieveAllProducts(HttpServletRequest request, HttpServletResponse response) {
		log.info("Get all product list");
		List<Product> productList = new ArrayList<Product>();
		productList = productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseBody createNewProduct(HttpServletRequest request, HttpServletResponse response) {
		log.info("Create new product");
		
		return null;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseBody editProduct(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		log.info("Edit product");
		
		return null;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseBody deleteProduct(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		log.info("Delete product");
		
		return null;
	}
}
