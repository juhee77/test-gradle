package com.lahee.psSocial.lecture.week8.thu.service;

import com.lahee.psSocial.lecture.week8.thu.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static final List<StudentDto> studentDtos = new ArrayList<>();
    private static long nextId=1L;

    public StudentDto createStudent( String name, String email) {
//        StudentDto studentDto = new StudentDto((long) studentDtos.size(), name, email);
        StudentDto studentDto = new StudentDto(nextId++, name, email);
        studentDtos.add(studentDto);
        return studentDto;
    }

    public List<StudentDto> getStudents() {
        return studentDtos;
    }
}
