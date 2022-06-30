package com.flashhammer.juicyfruit.controller;

import com.flashhammer.juicyfruit.model.HelloResponse;
import com.flashhammer.juicyfruit.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class TestHelloController {

    private HelloService getHelloService(){
        return new HelloService();
    }

    @GetMapping
    public HelloResponse hello(){
        return this.getHelloService().hello();
    }

}
