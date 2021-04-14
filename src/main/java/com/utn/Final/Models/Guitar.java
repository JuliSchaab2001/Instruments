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
public class Guitar extends Instrument{

    @NotNull(message = "El campo string es obligatorio")
    private String string;

    @Override
    public TypeInstrument typeInstrument() {
        return TypeInstrument.GUITAR;
    }
}
