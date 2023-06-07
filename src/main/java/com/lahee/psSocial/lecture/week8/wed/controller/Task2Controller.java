package com.lahee.psSocial.lecture.week8.wed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/week8/wed")
public class Task2Controller {
    private static int hitsCnt=0;
    @GetMapping("/hits")
    public String hits(Model model) {
        model.addAttribute("hitsCnt",++hitsCnt);
        return "/week8/wed/hits";
    }
}
