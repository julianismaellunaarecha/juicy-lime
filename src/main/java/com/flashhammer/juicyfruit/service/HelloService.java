package com.flashhammer.juicyfruit.service;

import com.flashhammer.juicyfruit.model.HelloResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {

    public HelloResponse hello() {
        HelloResponse helloResponse = new HelloResponse();
        Map<String, String> helloMap = new HashMap<>();
        helloMap.put("Hello", "human!");
        helloResponse.setResponse(helloMap);
        return helloResponse;
    }

}
