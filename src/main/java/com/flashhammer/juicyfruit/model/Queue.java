package com.flashhammer.juicyfruit.model;

import org.springframework.data.annotation.Id;

//@Document(collection = "Queue")
public class Queue {

    @Id
    private String uuid;
    private String value;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}