package com.gkfcsolution.shoppingcart.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created on 2025 at 12:38
 * File: ResponseOrderDTO.java.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 12:38
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrderDTO {
    private double amount;
    private Date date;
    private int invoiceNumber;
    private int orderId;
    private String orderDescription;


}
