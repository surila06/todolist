package com.spring.todolist.service;


import com.spring.todolist.exception.TaskNotFoundException;
import com.spring.todolist.model.Task;
import com.spring.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository=taskRepository;
    }

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

        if(taskRepository.findById(id).isEmpty())
            throw new TaskNotFoundException("Requested Task does not exist");
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findByTask(String taskName) {
        List<Task> taskList= (List<Task>) taskRepository.findByTask(taskName);
        return taskList;
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
