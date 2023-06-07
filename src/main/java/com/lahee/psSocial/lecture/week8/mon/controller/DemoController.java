package com.lahee.psSocial.lecture.week8.mon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/week8/mon")
public class DemoController {
//    @ResponseBody
//    @GetMapping("/")
//    public String getNHome() {
//        return "Here is home";
//    }

    @GetMapping("/home")
    public String home() {
        return "week8/mon/home";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "week8/mon/profile.html";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "week8/mon/blog";
    }
}
