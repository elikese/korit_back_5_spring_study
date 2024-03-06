package com.study.mvc.service;


import java.util.List;

public interface StudentService {

    List<?> getStudentList();
    Object getStudent(int index);
}
