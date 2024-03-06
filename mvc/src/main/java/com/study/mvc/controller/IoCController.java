package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndIoc.IoCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IoCController {

    @Autowired
    private IoCService ioCService;

    @GetMapping("/ioc")
    public ResponseEntity<?> iocTest() throws JsonProcessingException {
        return ResponseEntity.ok(ioCService.getJson());
    }

}