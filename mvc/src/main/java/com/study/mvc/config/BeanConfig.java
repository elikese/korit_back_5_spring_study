package com.study.mvc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration :
// bean 등록될떄 한번 실행됨.
// 1. Bean 수동등록(Scan에 의한게아님) ** 2개 이상 등록가능
// @Component 등록 이외의 방법임 -> 주로 재사용이 많은 Library 객체들을 등록함 (@Component가 사용불가능하기 때문)
// 2. 설정 관리

@Configuration
public class BeanConfig {

    @Bean // "objectMapper"이름으로 bean에 등록되어 싱글톤으로 관리된다.
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}