package com.utn.Final.Repositories;

import com.utn.Final.Models.Instrument;
import com.utn.Final.Models.TypeInstrument;
import com.utn.Final.Services.InstrumentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {
    //List<Instrument> findByTypeInstrument(TypeInstrument typeInstrument);

    List<Instrument> findByPrice(double price);
}
