package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
           Student chandni = new Student(
                    "computer Science",
                   "chandnirai.cs@gmail.com",
                    "chandni Rai",
                    LocalDate.of(2001, Month.JANUARY, 12)
            );

            Student alex = new Student(
                    "computer Science",
                    "Alex.cs@gmail.com",
                    "Alex",
                    LocalDate.of(2002, Month.JANUARY, 12)
            );

            repository.saveAll(
                    List.of(chandni, alex)
            );

        };
    }
}
