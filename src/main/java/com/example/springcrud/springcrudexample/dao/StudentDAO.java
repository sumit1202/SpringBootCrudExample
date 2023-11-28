package com.example.springcrud.springcrudexample.dao;

import java.util.List;

import com.example.springcrud.springcrudexample.entity.Student;

public interface StudentDAO {
    void saveStudent(Student theStudent);

    Student findStudentById(Integer id);

    List<Student> findAllStudent();

    List<Student> findStudentsByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAllStudent();
}
