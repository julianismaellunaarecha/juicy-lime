package com.flashhammer.juicyfruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EnableReactiveMongoRepositories
public class JuicyFruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuicyFruitApplication.class, args);
    }

}

