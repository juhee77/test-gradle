package com.lahee.psSocial.lecture.week8.wed.domain;


public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
