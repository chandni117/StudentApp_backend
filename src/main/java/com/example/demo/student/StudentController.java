package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
            return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path =  "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        studentService.updateStudent(id, name, email);
    }
//@PostMapping
//public ResponseEntity<String> addStudent(@RequestBody Student student) {
//    // logic here
//    studentService.addNewStudent(student);
//    return ResponseEntity.ok("Student added successfully");
//}
}
