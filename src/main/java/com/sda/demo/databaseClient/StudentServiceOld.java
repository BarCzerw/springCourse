package com.sda.demo.databaseClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceOld implements StudentService{

    @Autowired
    private StudentRepositoryCrude studentRepositoryCrude;

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepositoryCrude.findAll().forEach(studentList::add);
        return studentList;
    }
}
