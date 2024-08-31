package com.spring.todolist.repository;

import com.spring.todolist.model.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@DataJpaTest
public class TaskRepositoryTest {



    @Autowired
    private TaskRepository taskRepository;
    Task task;

    @BeforeEach
    void setUp()
    {
        task=new Task(7L,"Study_Jenkins",false);
        taskRepository.save(task);
    }

    //success test case
    @Test
    void  testFindByTaskName_Found()
    {
        List<Task> taskList=taskRepository.findByTask("Study_Jenkins");
        assertThat(taskList.get(0).getTask()).isEqualTo(task.getTask());
        assertThat(taskList.get(0).isCompleted()).isEqualTo(task.isCompleted());

   }

    //failure test case
    @Test
    void  testFindByTaskName_NotFound()
    {
        List<Task> taskList=taskRepository.findByTask("Study_Junit");
        assertThat(taskList.isEmpty()).isTrue();


    }

    @AfterEach
    void tearDown()
    {
        task=null;
        taskRepository.deleteAll();
    }



}
