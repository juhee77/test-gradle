package com.lahee.psSocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;

@RestController
public class test {

    @GetMapping("/")
    public String getMyMemberInfo() {
        return "hello";
    }

}
