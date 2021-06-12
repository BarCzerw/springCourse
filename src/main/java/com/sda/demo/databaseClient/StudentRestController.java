package com.sda.demo.databaseClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class StudentRestController {

    @Autowired
    private StudentRepositoryCrude studentRepositoryCrude;

    @Autowired
    private StudentServiceOld studentServiceOld;

    @Autowired
    private StudentServiceNew studentServiceNew;

    @Autowired
    private StudentConfiguration studentConfiguration;

    @PostMapping("/student/add")
    public void addStudent(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam double studentGrade,
            @RequestParam String universityName
    ) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGrade(studentGrade);
        student.setUniversityName(universityName);

        studentRepositoryCrude.save(student);
    }

    @PostMapping("/addDto")
    public void addStudentDTO(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setGrade(studentDTO.getGrade());
        student.setEmail(studentDTO.getEmail());
        student.setPesel(studentDTO.getPesel());
        student.setUniversityName(studentDTO.getUniversityName());
        studentRepositoryCrude.save(student);
    }

    @GetMapping("student/list")
    public List<Student> showAll(){
        if (studentConfiguration.isEnabled()) {
            log.info("StudentServiceNew used!");
            return studentServiceNew.getStudents();
        } else {
            log.info("StudentServiceOld used!");
            return studentServiceOld.getStudents();
        }
    }

    @GetMapping("student/grade")
    public List<Student> showStudentsByGrade(
            @RequestParam int minimumGrade
    ){
        return showAll().stream().filter(student -> student.getGrade() >= minimumGrade).collect(Collectors.toList());
    }

    @GetMapping("student/name")
    public List<Student> showStudentsByNameStart(
            @RequestParam String startToken
    ){
        return showAll().stream().filter(student -> student.getFirstName().startsWith(startToken)).collect(Collectors.toList());
    }

    @GetMapping("student/findById/{id}")
    public Student showStudentsById(
            @PathVariable long id
    ){
        return studentRepositoryCrude.findById(id).orElse(new Student());
    }

    @DeleteMapping("student/deleteById/{id}")
    public void deleteStudentById(
            @PathVariable long id
    ){
        studentRepositoryCrude.deleteById(id);
    }

    @PutMapping("student/edit/{id}/")
    public Student updateStudent(
            @PathVariable long id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Double studentGrade,
            @RequestParam String universityName
    ){
        Optional<Student> student = studentRepositoryCrude.findById(id);
        if (student.isPresent()) {
            Student studentFound = student.get();
            studentFound.setFirstName(firstName);
            studentFound.setLastName(lastName);
            studentFound.setGrade(studentGrade);
            studentFound.setUniversityName(universityName);
            return studentRepositoryCrude.save(studentFound);
        } else {
            log.error("Student with id:{} does not exist", id);
            return null;
        }
    }

}
