package com.utn.Final.Models;

import java.lang.reflect.Type;

public enum TypeInstrument {
    GUITAR("Guitar"),
    DRUM("Drum"),
    PIANO("Piano"),
    BASS("Bass"),
    FLUTE("Flute");

    private String description;

    TypeInstrument(String description) {
        this.description = description;
    }

    public static TypeInstrument find(String description){
        for(TypeInstrument v: values()){
            if(description.equalsIgnoreCase(v.toString())){
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid type of Instrument: %s",description));
    }

    public String getDescription() {
        return description;
    }
}
