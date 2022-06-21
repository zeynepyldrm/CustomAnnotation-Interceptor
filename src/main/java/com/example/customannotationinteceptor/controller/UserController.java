package com.example.customannotationinteceptor.controller;

import com.example.customannotationinteceptor.annotations.BscAuth;
import com.example.customannotationinteceptor.model.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @BscAuth
    @GetMapping
    public ResponseEntity<User> getUser(){
        User user=new User();
        user.username="auth var";
        user.password="123";
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> postUser(){
        User user=new User();
        user.username="auth yok";
        user.password="123";
        return ResponseEntity.ok(user);
    }
}
