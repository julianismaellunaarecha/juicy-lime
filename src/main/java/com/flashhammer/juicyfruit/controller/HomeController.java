package com.flashhammer.juicyfruit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "¡Bienvenido a Akshu!";
    }

}