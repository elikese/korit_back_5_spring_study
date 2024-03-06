package com.study.mvc.controller;

import com.study.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<?> selectStudent() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("student/{index}")
    public ResponseEntity<?> addStudent(@PathVariable int index) {
        if(studentService.getStudentList().size() >= index) {
            return ResponseEntity.badRequest().body(Map.of("errorMessage","해당index는 존재하지 않습니다"));
        }
        return ResponseEntity.ok().body(studentService.getStudent(index));
    }
}