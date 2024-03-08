package com.study.mvc.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class DBStudySelectRespDto {
    private int id;
    private String name;
    private int age;
}