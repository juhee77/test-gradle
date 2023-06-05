package com.lahee.psSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @ResponseBody
    @GetMapping("/")
    public String getNHome() {
        return "Here is home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile.html";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }
}
