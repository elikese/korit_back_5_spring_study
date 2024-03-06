package com.study.mvc.service;

import com.study.mvc.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// @Component("등록되는 bean 이름") -> 이름을 지정안하면 클래스이름 카멜표기법으로 추종함.
// 1. 여러 impl이 있는경우 (필드변수 이름 = 등록되는 bean이름) 을 만족하게 한다.
// 2. 여러 impl이 있는 경우 @Qualifier로 하나를 명시한다.

@Service
public class CarServiceImpl implements CarService{

    final String componentName = "a";

    @Autowired
    @Qualifier(componentName)
    private CarRepository carRepository;

    @Override
    public String getCarNames() {
        return String.join(",", carRepository.getCarName());
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
