package com.example.order_services.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private Long orderId;
    private Long productId;
    private int quantity;
    private double totalprice;

    //product details

    private String productname;
    private double productprice;
}
