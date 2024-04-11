package com.project.microservices.OrderService.service;
import com.project.microservices.OrderService.dto.OrderLineItemsDto;
import com.project.microservices.OrderService.dto.OrderReq;
import com.project.microservices.OrderService.model.Order;
import com.project.microservices.OrderService.model.OrderLineItems;
import com.project.microservices.OrderService.repo.OrderRepo;
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
    private OrderRepo orderRepo;

    @Autowired
    private OrderServiceProxy orderServiceProxy;


    public void placeOrder(OrderReq orderReq){
        Order order = new Order();
        List<OrderLineItems> orderLineItemsList = orderReq.getOrderLineItemsList().stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItemsList);
        order.setOrderNumber(UUID.randomUUID().toString());
        //call inventory service and place and order if product is in stock.
        boolean result = orderServiceProxy.retriveProductStock("Iphone_13");
        System.out.println("Order service Proxy result : = "+ result);
        if(result){
            orderRepo.save(order);
        }else{
            throw new IllegalArgumentException("Product is not in stock ,please try again later");
        }

    }


    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        BeanUtils.copyProperties(orderLineItemsDto,orderLineItems);
        return orderLineItems;
    }
}
