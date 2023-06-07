package com.lahee.psSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf");
        return "/week8/wed/home";
    }
}
