package com.project.microservices.OrderService.controller;
import com.project.microservices.OrderService.dto.OrderReq;
import com.project.microservices.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public  String getOrder(){
        return "current order";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderReq orderReq){
        orderService.placeOrder(orderReq);
        return "Order Placed Successfully !";
    }
}
