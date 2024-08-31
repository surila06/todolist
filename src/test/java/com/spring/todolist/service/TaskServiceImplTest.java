package com.spring.todolist.service;

import com.spring.todolist.model.Task;
import com.spring.todolist.repository.TaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;



class TaskServiceImplTest {

     @Mock
     private TaskRepository taskRepository;
    private TaskService taskService;
    AutoCloseable autoCloseable;
    Task task;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        taskService = new TaskServiceImpl(taskRepository);
        task= new Task(8L,"Study_Exception_Handling",false);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();

    }

    @Test
    void testCreateNewTask() {
        mock(Task.class);
        mock(TaskRepository.class);
        when(taskRepository.save(task)).thenReturn(task);
        assertThat(taskService.createNewTask(task).getId()).isEqualTo(task.getId());
    }

    @Test
    void testGetAllTasks() {
        mock(Task.class);
        mock(TaskRepository.class);
        when(taskRepository.findAll()).thenReturn(List.of(task));
        assertThat(taskService.getAllTasks().get(0).isCompleted()).isEqualTo(task.isCompleted());
    }

    @Test
    void testGetTaskById() {
        mock(Task.class);
        mock(TaskRepository.class);

        when(taskRepository.findById(8L)).thenReturn(Optional.ofNullable(task));
        assertThat(taskService.getTaskById(8L).getId()).isEqualTo(task.getId());
    }

    @Test
    void testFindByTask() {
        mock(Task.class);
        mock(TaskRepository.class);

        when(taskRepository.findByTask("Study_Exception_Handling")).thenReturn(List.of(task));
        assertThat(taskService.findByTask("Study_Exception_Handling").get(0).getId()).isEqualTo(task.getId());
    }

    @Test
    void deleteTask() {

        mock(Task.class);
        mock(TaskRepository.class, Mockito.CALLS_REAL_METHODS);

       // doAnswer(Answers.C)

    }

    @Test
    void findAllCompleteTask() {
    }

    @Test
    void findAllInCompleteTask() {
    }

    @Test
    void testUpdateTask() {
        mock(Task.class);
        mock(TaskRepository.class);
        when(taskRepository.save(task)).thenReturn(task);
        assertThat(taskService.updateTask(task).getId()).isEqualTo(task.getId());

    }
}