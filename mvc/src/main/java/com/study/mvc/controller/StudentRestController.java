package com.study.mvc.controller;

import com.study.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<?> selectStudent() {
        List<String> studentList = studentService.getStudentList();
        List<Map<String,String>> responseList = new ArrayList<>();
        studentList.forEach(studentName -> responseList.add(Map.of("name",studentName)));

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("student/{index}")
    public ResponseEntity<?> addStudent(@PathVariable int index) {
        if(index >= studentService.getStudentList().size()) {
            return ResponseEntity.badRequest().body(Map.of("errorMessage", "해당 index는 존재하지 않습니다"));
        }
        return ResponseEntity.ok().body(Map.of("name",studentService.getStudent(index)));
    }
}