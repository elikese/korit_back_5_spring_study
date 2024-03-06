package com.study.mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("a")
public class CarRepositoryImpl implements CarRepository{
    @Override
    public List<String> getCarName() {
        return List.of("아반떼","소나타");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량: " + carName);
        return 1;
    }
}