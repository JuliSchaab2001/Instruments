package com.utn.Final.Models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "TypeInstrument", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Drum.class, name = "DRUM"),
        @JsonSubTypes.Type(value = Guitar.class, name = "GUITAR"),
        @JsonSubTypes.Type(value = Piano.class, name = "PIANO")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El campos soundType no debe ser null")
    private String soundType;

    @NotNull(message = "El campo no debe ser null")
    private double price;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypeInstrument typeInstrument();



}
