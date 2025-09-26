package com.gkfcsolution.shoppingcart.entity.dto;

import com.gkfcsolution.shoppingcart.entity.Customer;
import com.gkfcsolution.shoppingcart.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created on 2025 at 12:38
 * File: OrderDTO.java.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 12:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private String orderDescription;
    private List<ShoppingCart> cartItems;
    private String customerEmail;
    private String customerName;


}
