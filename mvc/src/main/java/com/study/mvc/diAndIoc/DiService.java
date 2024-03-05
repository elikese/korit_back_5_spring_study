package com.study.mvc.diAndIoc;


import java.util.List;

public class DiService {

    private DiRepository diRepository;

    public DiService(DiRepository diRepository) {
        this.diRepository = diRepository;
    }

    public int getTotal() {
        int total = 0;
        List<Integer> scoreList = diRepository.getScoreList();
        for(Integer score : scoreList) {
            total += score;
        }
        return total;
    }

    public double getAverage() {
        int total = 0;
        double avg = 0;

        List<Integer> scoreList = diRepository.getScoreList();
        for(Integer score : scoreList) {
            total += score;
        }
        avg = total / scoreList.size();

        return avg;
    }
}