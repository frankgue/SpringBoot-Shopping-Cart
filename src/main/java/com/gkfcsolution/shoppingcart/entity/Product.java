package com.gkfcsolution.shoppingcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 11:39
 * File: null.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 11:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int availableQuantity;
    private float price;

}
