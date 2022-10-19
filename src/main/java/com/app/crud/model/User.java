package com.app.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    private float salary;

    @OneToMany(mappedBy = "user")
    private List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Phone> phones = new ArrayList<>();
}
