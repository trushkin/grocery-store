package com.example.techtask.repository;

import com.example.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = """
            select u.id, u.email, u.user_status, sum(o.price * o.quantity) as total_sum from users u
            join orders o on u.id = o.user_id
            where o.order_status = 'DELIVERED'
            and extract(year from o.created_at) = :year
            group by u.id
            order by total_sum desc
            limit 1
            """)
    User findUserWithMaxTotalDeliveryCostForYear(int year);
}
