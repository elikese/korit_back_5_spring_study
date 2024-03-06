package com.study.mvc.service;

import com.study.mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<?> getStudentList() {
        List<Map<String,String>> studentMapList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudentListAll();
        studentList.forEach(studentName -> studentMapList.add(Map.of("name",studentName)));

        return studentMapList;
    }
    @Override
    public Map<String, String> getStudent(int index) {
        return Map.of("name",studentRepository.findStudentNameByIndex(index));
    }
}
