package com.microservice.project.orderservice.service;

import com.microservice.project.orderservice.dto.OrderLineItemsDto;
import com.microservice.project.orderservice.dto.OrderReq;
import com.microservice.project.orderservice.model.Order;
import com.microservice.project.orderservice.model.OrderLineItems;
import com.microservice.project.orderservice.repo.OrderRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public void placeOrder(OrderReq orderReq){
        Order order = new Order();
        List<OrderLineItems> orderLineItemsList = orderReq.getOrderLineItemsList().stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItemsList);
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepo.save(order);
    }


    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        BeanUtils.copyProperties(orderLineItemsDto,orderLineItems);
        return orderLineItems;
    }
}
