package com.study.mvc.controller;

import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DiController {

    /**
     * DI(Dependency Injection) - 의존성 주입
     */

    @GetMapping("/di")
    public ResponseEntity<?> diTest() {
        DiRepository diRepository = new DiRepository();
        DiService diService = new DiService(diRepository);
        Map<String, Object> responseData = Map.of("total", diService.getTotal(), "average", diService.getAverage());
        // ok() 만 body값을 바로 넣어도 됨.
        return ResponseEntity.ok(responseData);
    }
}