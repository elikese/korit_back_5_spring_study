package com.study.mvc.repository;

import org.springframework.stereotype.Component;

import java.util.List;

// @Component("등록되는 bean 이름") -> 이름을 지정안하면 클래스이름 카멜표기법으로 추종함.
// 1. 여러 impl이 있는경우 (필드변수 이름 = 등록되는 bean이름) 을 만족하게 한다.
// 2. 여러 impl이 있는 경우 @Qualifier로 하나를 명시한다.
@Component
public class CarRepositoryImpl2 implements CarRepository{
    @Override
    public List<String> getCarName() {
        return List.of("k3","k5");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량: " + carName);
        return 1;
    }
}