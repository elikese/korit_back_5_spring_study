package com.study.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 모든 메서드에 @ResponseBody 어노테이션을 단 것과 같다.
public class StudyRestController {

    @GetMapping("hello/test")
    public String hello() {
        return "Hello";
    }
}