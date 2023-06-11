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

    @GetMapping("/eachStudentView")
    public String eachStudentView(Model model, @RequestParam("studentId") long studentId) {
        StudentDto student = studentService.findByStudentId(studentId);
        model.addAttribute("student", student);
        return "/week8/thu/each-student";
    }

    @GetMapping("/{id}")
    public String read(Model model, @PathVariable("id") long id) {
        StudentDto student = studentService.findByStudentId(id);
        model.addAttribute("student", student);
        return "/week8/thu/each-student";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("email") String email) {

        StudentDto student = studentService.findByStudentId(Integer.parseInt(id));
        student.setEmail(email);
        student.setName(name);
        return "redirect:/week8/thu/" + id;
    }

    @PostMapping("/students/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        studentService.deleteByStudentId(Integer.parseInt(id));
        return "redirect:/week8/thu/home";
    }

    @GetMapping("/update/{studentId}")
    public String modify(Model model, @PathVariable("studentId") long studentId) {
        StudentDto student = studentService.findByStudentId(studentId);
        model.addAttribute("student", student);
        return "/week8/fri/update-view";
    }


    @PostMapping("/create")
    public String createStudent(@RequestParam("name") String name, @RequestParam("email") String email) {
        StudentDto student = studentService.createStudent(name, email);
        log.info("name:{}, email:{}", student.getName(), student.getEmail());

        return "redirect:/week8/thu/create-view";
    }

    @ResponseBody
    @GetMapping("/get-students")
    public List<StudentDto> createStudent() {
        return studentService.getStudents();
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "/week8/thu/home";
    }
}
