package com.study.mvc.controller;

import com.study.mvc.dto.StudentReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController{

    // 파라미터의 객체생성을 dispatcher가 요청 받은 시점에 인스턴스 생성함.

//    @GetMapping("/student1")
//    public Object getStudentInfo1(@RequestParam StudentReqDto studentReqDto) {
//        return studentReqDto.toRespDto();
//    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudentInfo(@ModelAttribute StudentReqDto studentReqDto) {
        // ResponseEntity -> 상태코드, 헤더설정 등 한번에 가능(메서드 체인: bodybuilder로 변환되었다가 body()메서드로 인해 ResponseEntity 객체로 반환 됨)
        return ResponseEntity.ok().body(studentReqDto.toRespDto());
    }
}