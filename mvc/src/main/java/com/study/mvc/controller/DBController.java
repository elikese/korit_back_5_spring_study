package com.study.mvc.controller;

import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.service.DBStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DBController {

    @Autowired
    private DBStudyService dbStudyService;
    // ***********************************  CREATE  *************************************** //
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBStudyReqDto ReqDto) {
        return ResponseEntity
                .created(null)
                .body(dbStudyService.crateStudy(ReqDto));
    }

    // ***********************************   READ   *************************************** //
    @GetMapping("/select/study/{id}")
    public ResponseEntity<?> selectStudyById(@PathVariable int id) {
        return ResponseEntity.ok(dbStudyService.findStudyById(id)) == null
                ? ResponseEntity.badRequest().body(Map.of("errorMessage","id :" + id + "은 존재하지않습니다"))
                : ResponseEntity.ok(dbStudyService.findStudyById(id));
    }
    @GetMapping("/select/study")
    public ResponseEntity<?> selectStudyById(@RequestParam String name) {
        return ResponseEntity.ok(dbStudyService.findStudyByName(name) == null
                ? ResponseEntity.badRequest().body(Map.of("errorMessage",name + "은(는) 존재하지않습니다"))
                : ResponseEntity.ok(dbStudyService.findStudyByName(name)));
    }
    @GetMapping("/select/study/all")
    public ResponseEntity<?> selectStudyAll() {
        return ResponseEntity.ok(dbStudyService.findStudyAll());
    }

    // ***********************************  DELETE  *************************************** //
    @DeleteMapping("/delete/study/{id}")
    public ResponseEntity<?> deleteStudyById(@PathVariable int id) {
        return ResponseEntity.ok(dbStudyService.deleteStudyById(id));
    }

    // ***********************************  UPDATE  *************************************** //
    // PUT -> 전체수정 (null, 0 값들도 기존값에 덮어씀) : PUT & PATCH -> 완전히 동일하지만 sementic 개념으로 나눔
    @PutMapping("/update/study/{id}")
    public ResponseEntity<?> updateStudy(
            @PathVariable int id,
            @RequestBody DBStudyReqDto reqDto) {
        return ResponseEntity.ok(dbStudyService.putById(id, reqDto));
    }
    // PATCH -> 부분수정 (null, 0 은 기존값을 보존)
    @PatchMapping("/update/study/{id}")
    public ResponseEntity<?> patchStudy(
            @PathVariable int id,
            @RequestBody DBStudyReqDto reqDto) {
        return ResponseEntity.ok(dbStudyService.patchById(id, reqDto));
    }
}