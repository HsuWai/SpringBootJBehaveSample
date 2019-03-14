package com.singtel.voucher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.singtel.voucher.entity.Product;
import com.singtel.voucher.repository.ProductRepository;

/**
 * Service layer
 *
 */
@Service("productService")
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * 
	 * Get all products
	 * @return List<Product>
	 */
	public List<Product> getAllProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	/**
	 * 
	 * Get product by id
	 * @return Product
	 */
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}
	
	/**
	 * 
	 * Create new product
	 * @param product
	 * @return Product
	 */
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	/**
	 * 
	 * Edit product information
	 * @param product
	 * @return Product
	 */
	public Product editProduct(Product product) {
		return productRepository.save(product);
	}
	
	/**
	 * 
	 * Delete product by id
	 * @param id
	 */
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
	
	/**
	 * 
	 * Get product by id
	 * @return Product
	 */
	public Product getProductByProductName(String productName) {
		return null;
	}
}
