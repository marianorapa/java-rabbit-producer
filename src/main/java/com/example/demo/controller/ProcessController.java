package com.example.demo.controller;

import com.example.demo.controller.dto.ProcessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    @GetMapping("/process")
    public ResponseEntity<ProcessResponse> process() {
        return new ResponseEntity<>(new ProcessResponse("Ok"), HttpStatus.OK);
    }

}
