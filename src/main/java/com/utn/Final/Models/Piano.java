package com.utn.Final.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Piano extends Instrument{

    @NotNull(message = "El campo keys es obligatorio")
    @Min(value = 12, message = "Un piano debe tener al menos una octava")
    private Integer keys;

    @Override
    public TypeInstrument typeInstrument() {
        return TypeInstrument.PIANO;
    }
}
