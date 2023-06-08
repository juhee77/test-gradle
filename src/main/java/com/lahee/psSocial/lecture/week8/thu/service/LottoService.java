package com.lahee.psSocial.lecture.week8.thu.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LottoService {
    private static int hits = 0;
    private static final List<List<Integer>> lottoHistory = new ArrayList<>();

    public int addHit() {
        return ++hits;
    }


    public List<Integer> getLotto() {
        List<Integer> rangeNumList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            rangeNumList.add(i);
        }

        List<Integer> lotto = getLottoNums(rangeNumList);
        lottoHistory.add(lotto);
        return lotto;
    }

    private static List<Integer> getLottoNums(List<Integer> originalList) {
        List<Integer> lotto = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(originalList.size());
            int selectedNumber = originalList.get(randomIndex);
            lotto.add(selectedNumber);
            originalList.remove(randomIndex);
        }
        return lotto;
    }

    public List<List<Integer>> getLottoHistory() {
        return lottoHistory;
    }
}
