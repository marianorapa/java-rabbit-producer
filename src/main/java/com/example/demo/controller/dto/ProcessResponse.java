package com.example.demo.controller.dto;

public class ProcessResponse {

    private String data;

    public ProcessResponse() {
    }

    public ProcessResponse(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
