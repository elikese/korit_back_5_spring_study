package com.study.mvc.service;

import com.study.mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<String> getStudentList() {
        return studentRepository.getStudentListAll();
    }

    @Override
    public String getStudent(int index) {
        return studentRepository.findStudentNameByIndex(index);
    }
}
