package com.demo.flywaytest.input.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "todos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MariaDBTodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private boolean completed;
}
