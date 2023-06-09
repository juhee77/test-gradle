package com.lahee.psSocial.lecture.week8.wed.controller;

import com.lahee.psSocial.lecture.week8.wed.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/week8/wed")
public class MvcController {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf");
        return "/week8/wed/home";
    }


    @RequestMapping("/student")
    public String student(Model model) {
        Student attributeValue = new Student("juhee", "hello");
        model.addAttribute("object", attributeValue);
        return "/week8/wed/student";
    }

    @RequestMapping("/is-logged-in")
    public String isLoggedIn(Model model) {
        model.addAttribute("isLoggedIn", true);
        return "/week8/wed/if-unless";
    }

    @RequestMapping("/please-log-in")
    public String logIn(Model model) {
        model.addAttribute("isLoggedIn", false);
        return "/week8/wed/if-unless";
    }

    //개인 추가
    @RequestMapping("/login-test/{status}")
    public String isLoggedIn(Model model, @PathVariable("status") boolean flag) {
        model.addAttribute("isLoggedIn", flag);
        return "/week8/wed/if-unless";
    }


    @RequestMapping("/each-string")
    public String iterm(Model model) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("lulu");
        listOfStrings.add("lala");
        listOfStrings.add("haha");

        model.addAttribute("listOfStrings", listOfStrings);
        return "/week8/wed/each";
    }
    @RequestMapping("/each-student")
    public String itermStudent(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("test1", "test1@email.com"));
        students.add(new Student("test2", "test2@email.com"));
        students.add(new Student("test3", "test3@email.com"));

        model.addAttribute("students", students);
        return "/week8/wed/students";
    }

    @RequestMapping("/each-student-empty")
    public String itermStudentEmpty(Model model) {
        List<Student> students = new ArrayList<>();

        model.addAttribute("students", students);
        return "/week8/wed/students";
    }
}
