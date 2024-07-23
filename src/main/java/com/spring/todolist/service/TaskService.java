package com.spring.todolist.service;

import com.spring.todolist.model.Task;

import java.util.List;


public interface TaskService {

    Task createNewTask(Task task);
    List<Task> getAllTasks();


    List<Task> findAllCompleteTask();
    List<Task> findAllInCompleteTask();

   Task getTaskById(Long id);

   void deleteTask(Task task);

    Task updateTask(Task task);
}
