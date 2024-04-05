package com.example.demo.controller.dto;

public class ProcessRequest {

    private String content;
    private String topic;

    public ProcessRequest(String content) {
        this.content = content;
    }

    public ProcessRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
