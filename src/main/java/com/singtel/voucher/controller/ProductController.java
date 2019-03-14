package com.singtel.voucher.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.singtel.voucher.entity.Product;
import com.singtel.voucher.exception.InvalidRequestException;
import com.singtel.voucher.exception.ProductNotFoundException;
import com.singtel.voucher.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Controller for api request
 *
 */
@RestController
@RequestMapping("api/")
public class ProductController {

	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "product", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation("Returns list of all products in the system.")
	public ResponseEntity<?> retrieveAllProducts() {
		log.info("Get all product list");
		List<Product> productList = new ArrayList<Product>();
		productList = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation("Returns a specific product by its identifier. 404 if product does not exist.")
	public ResponseEntity<?> getProductById(@ApiParam(example = "1") @PathVariable("id") int id) {
		log.info("View product : " + id);
		Product product = null;
		try {
			product = productService.getProductById(id);
		}catch(Exception ex) {
			log.error("Get product error " + ex.getMessage());
			throw new ProductNotFoundException("Product not found ");
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "product", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation("Create a new product. productName, productDescription and productPrice are required.")
	public ResponseEntity<?> createNewProduct(@RequestBody HashMap<String,String> productRequest) {
			
		log.info("Create new product");
		Product product = new Product();
		
		String productName = productRequest.get("productName");
		String productDesc = productRequest.get("productDescription");
		String productPrice = productRequest.get("productPrice");
		
		log.info("Product name : "+ productName + ", productDesc : " + productDesc + ", productPrice : "+ productPrice);
		if( productName == null || productName.isEmpty() ) {
			throw new InvalidRequestException("Product name is required");
		}
		
		if( productDesc == null || productDesc.isEmpty() ) {
			throw new InvalidRequestException("Product description is required");
		}
		
		if( productPrice == null || productPrice.isEmpty()) {
			throw new InvalidRequestException("Product price is required");
		}
		
		product.setProductName(productName);
		product.setProductDescription(productDesc);
		product.setProductPrice(Double.parseDouble(productPrice));
		product = productService.createProduct(product);
		
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation("Update the person from the system and identifier is needed. 404 if product does not exist.")
	public ResponseEntity<?> editProduct(	@ApiParam(example = "1") @PathVariable("id") int id,
											@RequestBody HashMap<String,String> productRequest) {
			/*
			 * @ApiParam( examples = @Example(value= {
			 * 
			 * @ExampleProperty(value =
			 * "{'productRequest'：{'productName': 'Adapter', 'productDescription': 'Adapter', 'productPrice': 50}}"
			 * , mediaType = "application/json")}))
			 */
											
		log.info("Edit product : id : "+ id);

		Product product = null;
		try {
			product = productService.getProductById(id);
		}catch(Exception ex) {
			throw new ProductNotFoundException("Product is not found for id : "+ id);
		}
		
		String productName = productRequest.get("productName");
		String productDesc = productRequest.get("productDescription");
		String productPrice = productRequest.get("productPrice");
		
		log.info("Product name : "+ productName + ", productDesc : " + productDesc + ", productPrice : "+ productPrice);
		if( productName == null || productName.isEmpty() ) {
			throw new InvalidRequestException("Product name is required");
		}
		
		if( productDesc == null || productDesc.isEmpty() ) {
			throw new InvalidRequestException("Product description is required");
		}
		
		if( productPrice == null || productPrice.isEmpty()) {
			throw new InvalidRequestException("Product price is required");
		}
		
		product.setProductName(productName);
		product.setProductDescription(productDesc);
		product.setProductPrice(Double.parseDouble(productPrice));
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		product.setLastModifiedTime(ts);
		Product updated_product = productService.editProduct(product);
		
		log.info("Updated Successfully.");
		return new ResponseEntity<Product>(updated_product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
	@ApiOperation("Deletes a product from the system. 404 if product does not exist.")
	public ResponseEntity<?> deleteProduct(	@ApiParam(defaultValue = "1") @PathVariable("id") int id) {
		log.info("Delete product : "+ id);
		
		Product product = null;
		try {
			product = productService.getProductById(id);
			productService.deleteProduct(id);
		}catch(Exception ex) {
			throw new ProductNotFoundException("Product is not found for id : "+ id);
		}
		
		return new ResponseEntity<String>("Product is deleted successfully.", HttpStatus.OK);
	}
}
