package com.demo.flywaytest.controller;

import com.demo.flywaytest.output.entities.TodoEntity;
import com.demo.flywaytest.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<TodoEntity>> getTodos() {
        return new ResponseEntity<>(todoService.transferTodos(), HttpStatus.OK);
    }
}
