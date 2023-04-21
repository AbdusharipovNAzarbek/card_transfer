package com.company.card_transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList<User> userDetailsList = new ArrayList<>(
                Arrays.asList(new User("uzcard", passwordEncoder.encode("8600"), new ArrayList<>()),
                        (new User("humo", passwordEncoder.encode("9860"), new ArrayList<>())),
                        (new User("visa", passwordEncoder.encode("4455"), new ArrayList<>()))));
        for (UserDetails userDetails : userDetailsList) {
            if (userDetails.getUsername().equals(username)) {
                return userDetails;
            }
        }
        return null;
    }
}
