package com.lahee.psSocial.lecture.week8.thu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/week8/thu")
@Slf4j
public class FormController {
    @RequestMapping("/send")
    public String getForm() {
        return "/week8/thu/send";
    }

    @RequestMapping("/receive")
    public String receive(@RequestParam("message") String message ,@RequestParam("name") String nm) {

        log.info("name :{}, message :{}",nm, message);
        return "/week8/thu/send";
    }
}
