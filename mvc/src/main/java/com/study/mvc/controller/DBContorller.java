package com.study.mvc.controller;

import com.study.mvc.dto.DBStudyReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBContorller {

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBStudyReqDto dto) {
        System.out.println(dto);
        return ResponseEntity.ok(null);
    }
}
