package ru.phones.book.model.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ABONENT_VIEW")
public class AbonentView {
    @Id
    private Long id;

    private String firstname;
    private String lastname;
    private String position;
    private String departament;
    private String city;
    private String street;
    private String build;
    private Integer external;
    private Short internal;
    private Long personal;
    private Date wasadded;

    @Column(name = "headofunit_firstname")
    private String headOfUnitFirstname;

    @Column(name = "headofunit_lastname")
    private String headOfUnitLastname;
}

