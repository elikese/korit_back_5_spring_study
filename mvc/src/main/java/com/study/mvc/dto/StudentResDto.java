package com.study.mvc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResDto {
    private String name;
    private int age;
    private String phone;
    private String address;

}
