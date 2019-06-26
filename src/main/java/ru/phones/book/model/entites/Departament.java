package ru.phones.book.model.entites;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Departament {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique=true)
    private String departament;

    @NotNull
    private String description;
}
