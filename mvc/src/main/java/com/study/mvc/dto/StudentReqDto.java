package com.study.mvc.dto;

import lombok.Data;

@Data
public class StudentReqDto {
    private String name;
    private int age;
    private String phone;
    private String address;

    public StudentResDto toRespDto() {
        return StudentResDto.builder().name(name).age(age).phone(phone).address(address).build();
    }
}
