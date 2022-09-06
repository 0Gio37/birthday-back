package com.example.birthdayback.controller;

import com.example.birthdayback.model.Users;
import com.example.birthdayback.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = {""})
    public ResponseEntity<Users> loginUser(@RequestParam("username") String username,
                                           @RequestParam("password") String password){
        if(usersService.login(username, password) == null ){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(usersService.login(username, password));
        }

    };



}
