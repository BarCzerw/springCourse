package com.sda.demo.databaseClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceNew implements StudentService{

    @Autowired
    private StudentRepositoryJPA studentRepositoryJPA;

    @Override
    public List<Student> getStudents() {
        return studentRepositoryJPA.findAll();
    }
}
