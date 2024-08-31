package com.spring.todolist.controller;

import com.spring.todolist.model.Task;
import com.spring.todolist.service.TaskService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;
    Task taskOne;
    Task taskTwo;
    List<Task> taskList=new ArrayList<>();

    @BeforeEach
    void setUp() {

        taskOne=new Task(9L,"Clean_Sheets",false);
        taskTwo=new Task(10L,"Fold_Laundry",false);
        taskList.add(taskOne);
        taskList.add(taskTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllTasks() throws Exception {

        when(taskService.getTaskById(9L)).thenReturn(taskOne);
        this.mockMvc.perform(get("/api/tasks"+"/9")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createTask() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void deleteTaskById() {
    }
}