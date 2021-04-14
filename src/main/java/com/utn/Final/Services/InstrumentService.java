package com.utn.Final.Services;

import com.utn.Final.Models.Instrument;
import com.utn.Final.Models.TypeInstrument;
import com.utn.Final.Repositories.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class InstrumentService {

    private InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }



    public List<Instrument> getAll() {
        return instrumentRepository.findAll();
    }

    public Instrument getById(Integer id){
        return instrumentRepository.findById(id).orElseThrow( () -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void add(Instrument instrument){
        instrumentRepository.save(instrument);
    }

    public void delete(Integer id) {
        instrumentRepository.deleteById(id);
    }

    /*public List<Instrument> getByInstrumentType(TypeInstrument typeInstrument) {
        return instrumentRepository.findByTypeInstrument(typeInstrument);
    }*/

    public List<Instrument> getByPrice(double price) {
        return instrumentRepository.findByPrice(price);
    }
}
