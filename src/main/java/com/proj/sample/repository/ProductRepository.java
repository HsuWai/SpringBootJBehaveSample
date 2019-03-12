package com.proj.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proj.sample.entity.Product;

/**
 * Repository for product
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
