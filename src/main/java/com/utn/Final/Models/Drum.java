package com.utn.Final.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Drum extends Instrument{

    @NotNull(message = "El campo brand es obligatorio")
    private String brand;


    @Override
    public TypeInstrument typeInstrument() {
        return TypeInstrument.DRUM;
    }
}
