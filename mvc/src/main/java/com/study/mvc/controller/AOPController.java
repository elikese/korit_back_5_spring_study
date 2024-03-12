package com.study.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {

    @GetMapping("/aop")
    public ResponseEntity<?> paramsTest() {

        return ResponseEntity.ok(null);
    }
}
