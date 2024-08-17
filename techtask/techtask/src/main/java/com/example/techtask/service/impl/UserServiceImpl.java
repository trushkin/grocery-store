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
    private static final int TEST_YEAR = 2003;
    @Override
    public User findUser() {
        return userRepository.findUserWithMaxTotalDeliveryCostForYear(TEST_YEAR);
    }

    @Override
    public List<User> findUsers() {
        return null;
    }
}
