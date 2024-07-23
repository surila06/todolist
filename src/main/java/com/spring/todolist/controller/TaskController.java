package com.spring.todolist.controller;


import com.spring.todolist.model.Task;
import com.spring.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllCompleteTask());
    }

    @GetMapping("/incompleted")
    public ResponseEntity<List<Task>> getAllInCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllInCompleteTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    //@PutMapping("/{id})")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long id) {
        Task taskToBeDeleted = taskService.getTaskById(id);
        taskService.deleteTask(taskToBeDeleted);
        return ResponseEntity.ok("deleted successfully ");
    }

}
