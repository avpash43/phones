package ru.phones.book.model.entites;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Abonent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long employee;

    @NotNull
    private Long position;

    @NotNull
    private Long departament;

    @NotNull
    private Long address;

    @NotNull
    private Long phonenumber;

    @NotNull
    private Long headofunit;

    @NotNull
    private Date wasadded;

    @PrePersist
    void wasAdded() {
        this.wasadded = new Date();
    }
}
