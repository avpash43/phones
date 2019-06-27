package ru.phones.book.model.entites;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique=true)
    private String position;

    @NotNull
    private String description;

    public Position(@NotNull String position, @NotNull String description) {
        this.position = position;
        this.description = description;
    }
}
