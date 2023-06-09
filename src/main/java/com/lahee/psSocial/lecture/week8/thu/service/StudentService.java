package com.lahee.psSocial.lecture.week8.thu.service;

import com.lahee.psSocial.lecture.week8.thu.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static final List<StudentDto> studentDtos = new ArrayList<>();
    private static long nextId = 1L;


    public StudentService() {
        createStudent("test2", "test1@email.com");
        createStudent("test2", "test2@email.com");
        createStudent("test3", "test3@email.com");
    }

    public StudentDto createStudent(String name, String email) {

//        StudentDto studentDto = new StudentDto((long) studentDtos.size(), name, email);
        StudentDto studentDto = new StudentDto(nextId++, name, email);
        studentDtos.add(studentDto);
        return studentDto;
    }

    public List<StudentDto> getStudents() {
        return studentDtos;
    }

    public StudentDto findByStudentId(long studentId) {
//        System.out.println("SIZE : " + studentDtos.size());
//        return studentDtos.get((int) studentId - 1);
        for (StudentDto studentDto : studentDtos) {
            if (studentDto.getId() == studentId) {
                return studentDto;
            }
        }
        throw new RuntimeException("없는 학생");
    }

    public void deleteByStudentId(long studentId) {
        for (int i = 0; i < studentDtos.size(); i++) {
            if (studentDtos.get(i).getId() == studentId) {
                studentDtos.remove(i);
                return;
            }
        }
        throw new RuntimeException("없는 학생 입니다.");
    }
}
