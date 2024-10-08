package com.demo.flywaytest.service;

import com.demo.flywaytest.input.entities.MariaDBTodoEntity;
import com.demo.flywaytest.output.entities.TodoEntity;
import com.demo.flywaytest.output.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final MariaDBTodoService mariaDBTodoService;


    public List<TodoEntity> transferTodos() {
        List<TodoEntity> todos = todoRepository.findAll();
        List<MariaDBTodoEntity> completedList = todos.stream().filter(TodoEntity::isCompleted).map(this::map).toList();
        mariaDBTodoService.saveCompletedTodos(completedList);
        return todos;
    }

    private MariaDBTodoEntity map(TodoEntity todoEntity) {
        MariaDBTodoEntity result =new MariaDBTodoEntity();
        result.setCompleted(todoEntity.isCompleted());
        result.setTitle(todoEntity.getTitle());
        return result;
    }

}
