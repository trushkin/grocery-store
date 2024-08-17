package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final int TEST_YEAR_FOR_MAX_TOTAL_DELIVERY_COST = 2003;
    private static final int TEST_YEAR_FOR_FIND_USERS_WITH_PAID_ORDERS = 2010;
    @Override
    public User findUser(){
        return userRepository.findUserWithMaxTotalDeliveryCostForYear(TEST_YEAR_FOR_MAX_TOTAL_DELIVERY_COST);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findUsersWithPaidOrdersForYear(TEST_YEAR_FOR_FIND_USERS_WITH_PAID_ORDERS);
    }
}
