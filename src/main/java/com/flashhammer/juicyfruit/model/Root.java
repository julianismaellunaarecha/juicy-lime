package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root {
    int totalPages;
    int totalElements;
    int numberOfElements;
    Pageable pageable;
    Sort sort;
    boolean last;
    boolean first;
    int size;
    List<Object> objects;
    int number;

    String error;

    String code;

    @JsonProperty("last")
    public boolean isLast() {
        return last;
    }

    @JsonProperty("first")
    public boolean isFirst() {
        return first;
    }

    @JsonProperty("error")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("totalPages")
    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("totalElements")
    public int getTotalElements() {
        return this.totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    @JsonProperty("numberOfElements")
    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @JsonProperty("pageable")
    public Pageable getPageable() {
        return this.pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    @JsonProperty("sort")
    public Sort getSort() {
        return this.sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @JsonProperty("last")
    public boolean getLast() {
        return this.last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @JsonProperty("first")
    public boolean getFirst() {
        return this.first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    @JsonProperty("size")
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @JsonProperty("content")
    public List<Object> getObjects() {
        return this.objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    @JsonProperty("number")
    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

