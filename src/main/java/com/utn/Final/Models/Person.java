package com.utn.Final.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "El campo name no debe ser nulo")
    private String name;

    @NotNull(message = "El campo lastName no debe ser nulo")
    private String lastName;

    @NotNull(message = "El campo age no debe ser nulo")
    @Min(value = 0, message = "No puede ingresar una edad menor a 0")
    private Integer age;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private List<Instrument> instrumentList;

}
