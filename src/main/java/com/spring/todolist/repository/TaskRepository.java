package com.spring.todolist.repository;

import com.spring.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    public Task findByTask(String task);

    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findAll();
    public Task getById(Long id);


}
