package ru.phones.book.model.entites;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique=true)
    private String city;

    @NotNull
    private String street;

    @NotNull
    private String build;
}
