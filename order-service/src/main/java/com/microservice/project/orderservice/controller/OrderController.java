package com.microservice.project.orderservice.controller;

import com.microservice.project.orderservice.dto.OrderReq;
import com.microservice.project.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderReq orderReq){
        orderService.placeOrder(orderReq);
        return "Order Placed Successfully !";
    }
}
