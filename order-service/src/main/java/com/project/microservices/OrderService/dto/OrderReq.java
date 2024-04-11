package com.project.microservices.OrderService.dto;

import java.util.List;

public class OrderReq {
    private List<OrderLineItemsDto> orderLineItemsList;

    public List<OrderLineItemsDto> getOrderLineItemsList() {
        return orderLineItemsList;
    }

    public void setOrderLineItemsList(List<OrderLineItemsDto> orderLineItemsList) {
        this.orderLineItemsList = orderLineItemsList;
    }
}
