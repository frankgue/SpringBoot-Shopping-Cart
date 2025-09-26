package com.gkfcsolution.shoppingcart.service;

import com.gkfcsolution.shoppingcart.entity.Order;
import com.gkfcsolution.shoppingcart.entity.Product;
import com.gkfcsolution.shoppingcart.entity.ShoppingCart;
import com.gkfcsolution.shoppingcart.repository.OrderRepository;
import com.gkfcsolution.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created on 2025 at 11:49
 * File: null.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 11:49
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order getOrderDetail(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    public float getCartAmount(List<ShoppingCart> shoppingCartList) {
      float totalCartAmount = 0f;
      float singleCartAmount = 0f;
      int availableQuantity = 0;

      for(ShoppingCart cart: shoppingCartList){

          int productId = cart.getProductId();
          Optional<Product> product = productRepository.findById(productId);
          if (product.isPresent()){
              Product product1 = product.get();
              if (product1.getAvailableQuantity() < cart.getQuantity()){
                  singleCartAmount = product1.getPrice()*product1.getAvailableQuantity();
                  cart.setQuantity(product1.getAvailableQuantity());
              } else {
                  singleCartAmount = cart.getQuantity()*product1.getPrice();
                  availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
              }

              totalCartAmount = totalCartAmount + singleCartAmount;
              product1.setAvailableQuantity(availableQuantity);
              availableQuantity = 0;
              cart.setProductName(product1.getName());
              cart.setAmount(singleCartAmount);
              productRepository.save(product1);
          }

      }
      return totalCartAmount;
    }

    public Order saveOrder(Order order) {
        return  orderRepository.save(order);
    }
}
