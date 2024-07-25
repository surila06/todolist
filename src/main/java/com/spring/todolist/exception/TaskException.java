package com.spring.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class TaskException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;

}
