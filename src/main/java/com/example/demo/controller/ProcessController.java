package com.example.demo.controller;

import com.example.demo.controller.dto.ProcessRequest;
import com.example.demo.controller.dto.ProcessResponse;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/process")
    public ResponseEntity<ProcessResponse> process(@RequestBody ProcessRequest request) {
        messageService.sendMessage(request.getContent(), request.getSeverity());
        return new ResponseEntity<>(new ProcessResponse("Processing"), HttpStatus.OK);
    }

}
