package com.singtel.voucher.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.singtel.voucher.pojo.ProductRequest;
import com.singtel.voucher.service.ProductService;
import io.swagger.annotations.*;

/**
 * Controller for api request
 *
 */
@RestController
@RequestMapping("api/v2/")
public class ProductController_v2 {

	private static final Logger log = LoggerFactory.getLogger(ProductController_v2.class);

	@Autowired
	private ProductService productService;
	
	/**
	 * Get all products
	 * @return ResponseEntity<?>
	 */
	@RequestMapping(value = "product", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Return list of all products in the system.")
	public ResponseEntity<?> getAllProducts() {
		log.info("Get all product list");
		List<Product> productList = new ArrayList<Product>();
		productList = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	/**
	 * Get product by id
	 * @param id
	 * @return ResponseEntity<?>
	 */
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Return a specific product by its identifier. 404 if product does not exist.", response = Product.class)
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Product is not found")
			})
	public ResponseEntity<?> getProductByProductId(@ApiParam(example = "1", required = true) @PathVariable("id") int id) {
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
	
	/**
	 * create product
	 * @param productRequest
	 * @return ResponseEntity<?>
	 */
	@RequestMapping(value = "product", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Create a new product. productName, productDescription and productPrice are required.", response = Product.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Product creation is successful."),
			@ApiResponse(code = 400, message = "Invalid Input")
			})
	public ResponseEntity<?> createProduct( @ApiParam(required = true) @RequestBody ProductRequest productRequest) {
		
		log.info("Create new product");
		Product product = new Product();
		String productName = productRequest.getProductName();
		String productDesc = productRequest.getProductDescription();
		double productPrice = productRequest.getProductPrice();
		
		log.info("Product name : "+ productName + ", productDesc : " + productDesc + ", productPrice : "+ productPrice);
		if( productName == null || productName.isEmpty() ) {
			throw new InvalidRequestException("Product name is required");
		}
		if( productDesc == null || productDesc.isEmpty() ) {
			throw new InvalidRequestException("Product description is required");
		}
		if( productPrice == 0.0) {
			throw new InvalidRequestException("Product price is required");
		}
		
		product.setProductName(productName);
		product.setProductDescription(productDesc);
		product.setProductPrice(productPrice);
		product = productService.createProduct(product);
		if(product.getId() != 0 ) {
			Product new_product = productService.getProductById(product.getId());
			return new ResponseEntity<Product>(new_product, HttpStatus.CREATED);
		}else {
			log.info("Product creation fails.");
			return new ResponseEntity<String>("Product creation fails.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * edit product
	 * @Param id
	 * @param productRequest
	 * @return ResponseEntity<?>
	 */
	@RequestMapping(value = "product/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ApiOperation(value = "Update the product from the system and identifier is needed. 404 if product does not exist.", response = Product.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 404, message = "Product is not found") 
			})
	public ResponseEntity<?> updateProduct(	@ApiParam(example = "1") @PathVariable("id") int id,
											@ApiParam(required = true) @RequestBody ProductRequest productRequest) {
		log.info("Edit product : id : "+ id);

		Product product = null;
		try {
			product = productService.getProductById(id);
		}catch(Exception ex) {
			throw new ProductNotFoundException("Product is not found for id : "+ id);
		}
		String productName = productRequest.getProductName();
		String productDesc = productRequest.getProductDescription();
		double productPrice = productRequest.getProductPrice();
		
		log.info("Product name : "+ productName + ", productDesc : " + productDesc + ", productPrice : "+ productPrice);
		
		if( productName == null || productName.isEmpty() ) {
			throw new InvalidRequestException("Product name is required");
		}
		
		if( productDesc == null || productDesc.isEmpty() ) {
			throw new InvalidRequestException("Product description is required");
		}
		
		if( productPrice == 0.0) {
			throw new InvalidRequestException("Product price is required");
		}
		
		product.setProductName(productName);
		product.setProductDescription(productDesc);
		product.setProductPrice(productPrice);
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		product.setLastModifiedTime(ts);
		Product updated_product = productService.editProduct(product);
		
		log.info("Updated Successfully.");
		return new ResponseEntity<Product>(updated_product, HttpStatus.OK);
	}
	
	/**
	 * delete product
	 * @param id
	 * @return ReponseEntity<?>
	 */
	@RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a product from the system. 404 if product does not exist.", response = String.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 404, message = "Product is not found") 
			})
	public ResponseEntity<?> deleteProductById(	@ApiParam(example = "1", required = true) @PathVariable("id") int id) {
		log.info("Delete product : "+ id);
		
		Product product = null;
		try {
			product = productService.getProductById(id);
			log.info("Product Name : " + product.getProductName());
			productService.deleteProduct(id);
		}catch(Exception ex) {
			throw new ProductNotFoundException("Product is not found for id : "+ id);
		}
		
		return new ResponseEntity<String>("Product is deleted successfully.", HttpStatus.OK);
	}
}
