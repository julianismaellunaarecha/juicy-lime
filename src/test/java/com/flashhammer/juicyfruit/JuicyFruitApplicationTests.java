package com.flashhammer.juicyfruit;

import com.flashhammer.juicyfruit.controller.MongoController;
import com.flashhammer.juicyfruit.controller.TestHelloController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JuicyFruitApplicationTests {

    public MongoController getMongoController(){
        return new MongoController();
    }

    public TestHelloController getTestHelloController(){
        return new TestHelloController();
    }

    @Test
    void contextLoads() {
        assertThat(this.getMongoController()).isNotNull();
    }

    @Test
    void hello() {
        assertThat(this.getTestHelloController().hello().getResponse().size()).isEqualTo(1);
    }

}
