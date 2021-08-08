package com.demo.service;

import com.demo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoService {

    List<ToDo> findAll();
}
