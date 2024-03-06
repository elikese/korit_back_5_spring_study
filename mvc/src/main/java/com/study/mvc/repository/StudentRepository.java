package com.study.mvc.repository;

import java.util.List;

public interface StudentRepository {
    List<String> getStudentListAll();
    String findStudentNameByIndex(int index);
}