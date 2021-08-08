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

    @MockBean
    private ToDoRepository toDoRepositoryMock;

    @Test
    void givenRepositoryFindAllMocked_WhenFindAllServiceMethodInvoked_ThenMockValueReturned() {
        ToDo todoSample = new ToDo("Todo Sample 1",true);
        when(toDoRepositoryMock.findAll()).thenReturn(Arrays.asList(todoSample));
        ToDoServiceImpl toDoServiceImpl = new ToDoServiceImpl(toDoRepositoryMock);

        List<ToDo> toDoList = toDoServiceImpl.findAll();
        ToDo lastToDo = toDoList.get(0);

        assertEquals(todoSample.getText(), lastToDo.getText());
        assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
        assertEquals(todoSample.getId(), lastToDo.getId());
    }
}
