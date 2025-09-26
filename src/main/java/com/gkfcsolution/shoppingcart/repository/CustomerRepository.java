package com.gkfcsolution.shoppingcart.repository;

import com.gkfcsolution.shoppingcart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created on 2025 at 11:56
 * File: null.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 11:56
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}
