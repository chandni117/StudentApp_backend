package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
        name="student_sequence",
        sequenceName="student_sequence",
            allocationSize=1

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    private  String course;
    @Transient
    private int age;


    public Student() {
    }

    public Student(String course, String email, long id, String name,  LocalDate dob) {
        this.course = course;
        this.email = email;
        this.id = id;
        this.dob = dob;
        this.name = name;
    }

    public Student(String course, String email, String name, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
