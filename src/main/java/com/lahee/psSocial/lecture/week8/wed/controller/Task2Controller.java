package com.lahee.psSocial.lecture.week8.wed.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/week8/wed")
public class Task2Controller {
    private static int hitsCnt=0;
    private static List<List<Integer>> lottoHistory = new ArrayList<>();
    @GetMapping("/hits")
    public String hits(Model model) {
        model.addAttribute("hitsCnt",++hitsCnt);
        return "/week8/wed/hits";
    }

    @GetMapping("/lotto")
    public String lotto(Model model) {
        List<Integer> originalList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            originalList.add(i);
        }

        List<Integer> lotto = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(originalList.size());
            int selectedNumber = originalList.get(randomIndex);
            lotto.add(selectedNumber);
            originalList.remove(randomIndex);
        }

        lottoHistory.add(lotto);
        model.addAttribute("lotto", lotto);
        return "/week8/wed/lotto";
    }
    @GetMapping("/history")
    public String lottoHistory(Model model) {
        model.addAttribute("lottoHistory", lottoHistory);
        return "/week8/wed/history";
    }
}
