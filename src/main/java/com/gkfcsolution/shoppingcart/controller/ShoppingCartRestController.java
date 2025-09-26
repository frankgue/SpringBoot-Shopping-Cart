package com.gkfcsolution.shoppingcart.controller;

import com.gkfcsolution.shoppingcart.entity.Customer;
import com.gkfcsolution.shoppingcart.entity.Order;
import com.gkfcsolution.shoppingcart.entity.Product;
import com.gkfcsolution.shoppingcart.entity.dto.OrderDTO;
import com.gkfcsolution.shoppingcart.entity.dto.ResponseOrderDTO;
import com.gkfcsolution.shoppingcart.service.CustomerService;
import com.gkfcsolution.shoppingcart.service.OrderService;
import com.gkfcsolution.shoppingcart.service.ProductService;
import com.gkfcsolution.shoppingcart.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * Created on 2025 at 11:51
 * File: null.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 11:51
 */
@RestController
@RequestMapping("/api/v1/shopping-cart")
public class ShoppingCartRestController {
    private final OrderService orderService;
    private final ProductService productService;
    private final CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger(ShoppingCartRestController.class);

    @Autowired
    public ShoppingCartRestController(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId){
        Order order = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }
    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO){
        logger.info("Request Payload " + orderDTO.toString());
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        float amount = orderService.getCartAmount(orderDTO.getCartItems());

        Customer customer = Customer.builder()
                .email(orderDTO.getCustomerEmail())
                .name(orderDTO.getCustomerName())
                .build();
        Integer customerIdFromDb = customerService.isCustomerPresent(customer);
        if (customerIdFromDb != null){
            customer.setId(customerIdFromDb);
            logger.info("Customer already present in db with id : " + customerIdFromDb);
        } else {
            customer = customerService.saveCustomer(customer);
            logger.info("Customer saved... with id : " + customer.getId()) ;
        }
        Order order = Order.builder()
                .orderDescription(orderDTO.getOrderDescription())
                .customer(customer)
                .cartItems(orderDTO.getCartItems())
                .build();
        order = orderService.saveOrder(order);
        logger.info("Order processed successfully..");

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(DateUtil.getCurrentDateTIme());
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
        responseOrderDTO.setOrderId(order.getId());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

        logger.info("test push");

        return ResponseEntity.ok(responseOrderDTO);
    }
}
