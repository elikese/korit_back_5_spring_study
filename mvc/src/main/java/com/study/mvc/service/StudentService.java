package com.study.mvc.service;

import com.study.mvc.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    List<String> getStudentList();
    String getStudent(int index);
}
