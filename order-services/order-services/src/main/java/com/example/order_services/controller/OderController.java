package com.example.order_services.controller;

import com.example.order_services.repository.OrderRepository;
import com.example.order_services.service.dto.OrderResponseDTO;
import com.example.order_services.service.dto.ProductDTO;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/orders")
public class OderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClient;

    //create a product order
    @PostMapping("/placeOrder")
    public Mono<ResponseEntity<OrderResponseDTO>> placeOrder(@RequestBody Order order) {

        //Fetch product details from product services
        return webClientBuilder.build().get().uri("http://localhost:8881/products/" +order.geyProductID()).retrive()
                .bodyToMono(ProductDTO.class).map(productDTO ->{
                    OrderResponseDTO resposeDTO =new OrderResponseDTO();

                    resposeDTO.setProductId(order.getproductId());
                    responseDTO.setQuantity(order.getQuantity());

                    //set product details
                    responseDTO.setProductName(productDTO.getName());
                    resposeDTO.setProductPrice(productDTO.getPrice());
                    resposeDTO.setTotalPrice(order.getQuantity() * productDTO.getPrice());

                    //save order details
                    orderRepository.save(order);
                    resposeDTO.setOrderId(order.getId());
                    return responseEntity.ok(responseDTO);

                })

    }
    //get all orders
    @GetMapping
    public List<Order> getAllorders(){
        return orderRepository.findAll();
    }
}
