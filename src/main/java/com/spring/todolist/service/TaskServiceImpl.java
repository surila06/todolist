package com.spring.todolist.service;


import com.spring.todolist.model.Task;
import com.spring.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task)
    {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public List<Task> findAllCompleteTask() {
        return taskRepository.findByCompletedTrue();
    }

    @Override
    public List<Task> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse();
    }



    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }


}
