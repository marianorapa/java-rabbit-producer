package com.example.demo.controller.dto;

public class ProcessRequest {

    private String content;
    private String severity;

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

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}
