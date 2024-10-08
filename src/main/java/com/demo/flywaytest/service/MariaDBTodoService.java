package com.demo.flywaytest.service;

import com.demo.flywaytest.input.entities.MariaDBTodoEntity;
import com.demo.flywaytest.input.repositories.MariaDBTodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MariaDBTodoService {

    private final MariaDBTodoRepository todoRepository;

    public void saveCompletedTodos(List<MariaDBTodoEntity> completedTodos) {
        todoRepository.saveAll(completedTodos);
    }
}
