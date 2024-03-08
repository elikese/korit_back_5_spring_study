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

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBStudyReqDto ReqDto) {
        return ResponseEntity
                .created(null)
                .body(dbStudyService.crateStudy(ReqDto));
    }

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

}