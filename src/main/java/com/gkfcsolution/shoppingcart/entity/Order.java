package com.gkfcsolution.shoppingcart.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
@Table(name = "myorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderDescription;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<ShoppingCart> cartItems;
}
