package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import com.example.techtask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private static final int TEST_QUANTITY = 1;

    @Override
    public Order findOrder() {
        return orderRepository.findNewestOrderWithQuantityMoreThan(TEST_QUANTITY);
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findOrdersFromActiveUsers();
    }
}
