package com.gkfcsolution.shoppingcart.service;

import com.gkfcsolution.shoppingcart.entity.Product;
import com.gkfcsolution.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2025 at 11:50
 * File: null.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 11:50
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
