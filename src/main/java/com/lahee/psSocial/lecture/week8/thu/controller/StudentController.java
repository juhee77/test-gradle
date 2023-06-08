package com.lahee.psSocial.lecture.week8.thu.controller;

import com.lahee.psSocial.lecture.week8.thu.model.StudentDto;
import com.lahee.psSocial.lecture.week8.thu.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/week8/thu")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/create-view")
    public String createView() {
        return "/week8/thu/create";
    }

    @PostMapping("/create")
    public String createStudent(@RequestParam("name") String name, @RequestParam("email") String email) {
        StudentDto student = studentService.createStudent(name, email);
        log.info("name:{}, email:{}", student.getName(), student.getEmail());

        return "redirect:/week8/thu/create-view";
    }

    @ResponseBody
    @GetMapping("/get-students")
    public List<StudentDto>  createStudent() {
        List<StudentDto> studentDtoList = studentService.getStudents();
        for (StudentDto student : studentDtoList) {
            log.info("name:{}, email:{}", student.getName(), student.getEmail());
        }

        return studentDtoList;
    }

    @GetMapping("/home")
    public String  home(Model model) {
        List<StudentDto> studentDtoList = studentService.getStudents();
        for (StudentDto student : studentDtoList) {
            log.info("name:{}, email:{}", student.getName(), student.getEmail());
        }

        model.addAttribute("students", studentDtoList);
        return "/week8/thu/home";
    }
}
