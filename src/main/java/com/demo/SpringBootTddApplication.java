package com.demo;

import com.demo.entity.ToDo;
import com.demo.repository.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootTddApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTddApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(ToDoRepository toDoRepository) {
        return (args) -> {
            toDoRepository.save(new ToDo("Add a new test case", true));
            toDoRepository.save(new ToDo("Make it fail", true));
            toDoRepository.save(new ToDo("Do changes to the code", false));
            toDoRepository.save(new ToDo("Pass the test", true));
        };
    }

}
