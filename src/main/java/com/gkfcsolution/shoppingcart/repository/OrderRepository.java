package com.gkfcsolution.shoppingcart.repository;

import com.gkfcsolution.shoppingcart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
