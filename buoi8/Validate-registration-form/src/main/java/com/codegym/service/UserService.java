package com.codegym.service;

import com.codegym.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public void save(User user) {
        System.out.println("Saved: " + user);

    }
}
