package com.demo.flywaytest.output.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "todos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TodoEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    private boolean completed;

    @Column
    private LocalDate creationDate;
}
