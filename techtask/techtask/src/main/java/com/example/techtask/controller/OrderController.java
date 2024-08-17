package com.example.techtask.controller;

import com.example.techtask.model.Order;
import com.example.techtask.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Attention! Only DI and service interaction applicable in this class. Each controller method
 * should only contain a call to the corresponding service method
 */
@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    // DI here
    private final OrderServiceImpl orderService;

    @GetMapping("desired-order")
    public Order findOrder() {
        return orderService.findOrder();
    }

    @GetMapping("desired-orders")
    public List<Order> findOrders() {
        return orderService.findOrders();
    }
}
