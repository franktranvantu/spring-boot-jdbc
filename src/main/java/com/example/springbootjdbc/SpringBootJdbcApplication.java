package com.example.springbootjdbc;

import com.example.springbootjdbc.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringBootJdbcApplication {

    private final JdbcTemplate jdbcTemplate;

    public SpringBootJdbcApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        List<Student> students = Arrays.asList(
                new Student("Frank", "frank@gmail.com"),
                new Student("Henry", "henry@gmail.com"),
                new Student("Bean", "bean@gmail.com")
        );
        return args -> {
            String sql = "INSERT INTO student(name, email) VALUES(?, ?)";
            List<Object[]> batchArgs = students.stream()
                    .map(student -> new String[] {student.getName(), student.getEmail()})
                    .collect(Collectors.toList());
            jdbcTemplate.batchUpdate(sql, batchArgs);
        };
    }
}
