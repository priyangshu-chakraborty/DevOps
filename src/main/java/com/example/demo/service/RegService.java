package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.login;
import com.example.demo.repository.LogRepo;

@Service
public class RegService {
    @Autowired
    private LogRepo userRepository;
    public login reg(String username, String password){
        login user=new login();
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
