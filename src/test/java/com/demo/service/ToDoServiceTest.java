package com.demo.service;

import com.demo.entity.ToDo;
import com.demo.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    void findAllInvoked_withValidTodoInDB_shouldReturnTodo() {
        ToDo todoSample = new ToDo("Todo Sample 1",true);
        toDoRepository.save(todoSample);
        ToDoServiceImpl toDoServiceImpl = new ToDoServiceImpl(toDoRepository);

        List<ToDo> toDoList = toDoServiceImpl.findAll();
        ToDo lastToDo = toDoList.get(toDoList.size() - 1);

        assertEquals(todoSample.getText(), lastToDo.getText());
        assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
        assertEquals(todoSample.getId(), lastToDo.getId());
    }

    @Test
    void saveAToDo() {
        ToDoServiceImpl toDoServiceImpl = new ToDoServiceImpl(toDoRepository);
        ToDo todoSample = new ToDo("Todo Sample 1",true);

        toDoServiceImpl.save(todoSample);

        assertEquals(1.0, toDoRepository.count());
    }
}
