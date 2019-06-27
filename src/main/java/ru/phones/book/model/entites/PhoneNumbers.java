package ru.phones.book.model.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class PhoneNumbers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer external;

    @NotNull
    private Short internal;

    @NotNull
    private Long personal;

    public PhoneNumbers(@NotNull Integer external, @NotNull Short internal, @NotNull Long personal) {
        this.external = external;
        this.internal = internal;
        this.personal = personal;
    }
}
