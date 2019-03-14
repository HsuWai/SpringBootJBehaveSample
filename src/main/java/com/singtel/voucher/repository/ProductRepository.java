package com.singtel.voucher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.singtel.voucher.entity.Product;

/**
 * Repository for product
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
