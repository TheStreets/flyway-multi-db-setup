package com.demo.flywaytest.input.repositories;

import com.demo.flywaytest.input.entities.MariaDBTodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MariaDBTodoRepository extends JpaRepository<MariaDBTodoEntity, Integer> {
}
