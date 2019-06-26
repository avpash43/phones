package ru.phones.book.model.entites;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstname;

    @NotNull
    @Column(unique=true)
    private String lastname;
}
