package com.spring.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskExceptionController {

    @ExceptionHandler(value={TaskNotFoundException.class})
    public ResponseEntity<Object> handleTaskException(RuntimeException ex)
    {
        RuntimeException customException= new RuntimeException(ex.getMessage(),ex.getCause());
         return new ResponseEntity<>(customException,HttpStatus.NOT_FOUND);
    }
}
