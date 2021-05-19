package com.example.sahil.auth.ldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {


    @GetMapping(path = "/")
    public String welcome(){
        return "<h1>Welcome</h1>";
    }


    @GetMapping(path = "/user")
    public String helloUser(){
        return "<h1>Welcome User</h1>";
    }


    @GetMapping(path = "/admin")
    public String helloWorld(){
        return "<h1>Welcome Admin</h1>";
    }
}
