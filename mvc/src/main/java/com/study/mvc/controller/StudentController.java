package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.dto.StudentReqDto;
import com.study.mvc.entity.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
public class StudentController {

    @PostMapping("/student")
    // @RequestBody & @ResponseBody : 자바 객체 <-> JSON 변환용으로 사용함
    // dispatcher가 @CookieValue 있으면 알아서 디코딩해서 꺼내옴
    public ResponseEntity<?> addStudent(@CookieValue(required = false) String students, @RequestBody Student student) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> studentList = new ArrayList<>();
        int lastId = 0;

        if (students != null && !students.isBlank()) {
            // MessageConverter 역할하는 Jackson 라이브러리에 있는 ObjectMapper임
            for (Object object : objectMapper.readValue(students, List.class)) {
                Map<String, Object> studentMap = (Map<String, Object>) object;
                studentList.add(objectMapper.convertValue(studentMap, Student.class));
            }
            lastId = studentList.get(studentList.size() - 1).getStudentId();
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);

        String studentListJson = objectMapper.writeValueAsString(studentList);

        ResponseCookie responseCookie = ResponseCookie
                .from("students", URLEncoder.encode(studentListJson, StandardCharsets.UTF_8))
                .httpOnly(true)
                .secure(true)
                .path("/") // "/auth" 라고 지정하면 localhost:8080/auth -> 이후로만 쿠키접근가능함
                .maxAge(60)
                .build();

        return ResponseEntity
                .created(null) // 201응답
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(studentListJson);
    }

    //    파라미터로 받아야하는 객체 생성을 요청 받은 시점에 dispatcher가 수행함 (bean 등록이 아님)
    //    @GetMapping("/student1")
    //    public Object getStudentInfo(@RequestParam StudentReqDto studentReqDto) {
    //        return studentReqDto.toRespDto();
    //    }

    //@ModelAttribute -> 파라미터 데이터바인딩 어노테이션
    @GetMapping("/student")
    public ResponseEntity<?> getStudentInfo(@ModelAttribute StudentReqDto studentReqDto) {
        // ResponseEntity -> 상태코드, 헤더설정 등 한번에 가능(메서드 체인: bodybuilder로 변환되었다가 body()메서드로 인해 ResponseEntity 객체로 반환 됨)
        return ResponseEntity.ok().body(studentReqDto.toRespDto());
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable("studentId") int id) {
        List<Student> studentList = List.of(
                new Student(1, "피카츄"),
                new Student(2, "라이츄"),
                new Student(3, "파이리"),
                new Student(4, "꼬부기")
        );

        Optional<Student> optionalStudent =
                studentList.stream().filter(student -> student.getStudentId() == id).findFirst();
        if (optionalStudent.isEmpty()) {
            return ResponseEntity.ok().body(Map.of("errorMessage", "존재하지 않는 ID입니다"));
        } else {
            Student findStudent = optionalStudent.get();
            return ResponseEntity.ok().body(findStudent);
        }

        //        ** List에서 get(0)하면 NullPointException e 발생 -> try - catch 써야됨 **
        //        try {
        //            Student findStudent = studentList.stream()
        //                    .filter(student -> student.getStudentId() == id)
        //                    .collect(Collectors.toList()).get(0);
        //            return ResponseEntity.ok().body(findStudent);
        //        } catch (Exception e) {
        //            return ResponseEntity.ok().body(Map.of("errorMessage","존재하지 않는 ID입니다"));
        //        }
    }

}