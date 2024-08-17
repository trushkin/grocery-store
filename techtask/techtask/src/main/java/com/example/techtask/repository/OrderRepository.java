package com.example.techtask.repository;

import com.example.techtask.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(nativeQuery = true, value = """
            select * from orders o
            where o.quantity > :quantity
            order by o.created_at desc
            limit 1;
            """)
    Order findNewestOrderWithQuantityMoreThan(int quantity);

    @Query(nativeQuery = true, value = """
            select o.id, o.product_name, o.price, o.quantity, o.user_id, o.created_at, o.order_status from orders o
            join users u on o.user_id = u.id
            where u.user_status = 'ACTIVE'
            order by o.created_at desc
            """)
    List<Order> findOrdersFromActiveUsers();
}
