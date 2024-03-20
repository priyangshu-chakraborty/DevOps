package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.login;
import com.example.demo.service.RegService;

@Controller
public class RegControl {
    @Autowired
    private RegService service;
 
    @GetMapping("/register")
    public String api()
    {
 
        return "register";
    }
 
    @PostMapping("/reg")
    public String login(@ModelAttribute("user") login user) {
 
        login oauthUser = service.reg(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/display";
        } else {
            return "redirect:/";
        }
    }
 
    @GetMapping("/display")
    public String display() {
        return "display";
    }
}
