package com.bhavicodes.order_service.controller;

import com.bhavicodes.base_domains.dto.Order;
import com.bhavicodes.base_domains.dto.OrderEvent;
import com.bhavicodes.order_service.kafka.OrderProducer;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

//creating constructor based dependency
    @Autowired
    private OrderProducer orderProducer;

    public void orderController(OrderProducer orderProducer)
    {
        //constructor injection
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public String placeOrder(@RequestBody Order order) {
        //message convertors to convert json object into java object
        order.setOderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order Status: PENDING");

        orderProducer.sendMessage(orderEvent);
        return "Order Placed Successfully";

    }
}
