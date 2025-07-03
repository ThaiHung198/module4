package com.codegym.service;

import com.codegym.model.Role;
import com.codegym.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {
    public static List<User> listUser = new ArrayList<>();
    public static List<Role> listroles = new ArrayList<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
