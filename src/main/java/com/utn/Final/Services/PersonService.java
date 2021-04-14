package com.utn.Final.Services;

import com.utn.Final.Models.Instrument;
import com.utn.Final.Models.Person;
import com.utn.Final.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private InstrumentService instrumentService;

    @Autowired
    public PersonService(PersonRepository personRepository, InstrumentService instrumentService) {
        this.personRepository = personRepository;
        this.instrumentService = instrumentService;
    }



    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }

    public Person getById(Integer personId) {
        return personRepository.findById(personId).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void addInstrumentToPerson(Integer personId, Integer instrumentId){
        Person person = getById(personId);
        Instrument instrument = instrumentService.getById(instrumentId);
        person.getInstrumentList().add(instrument);
        personRepository.save(person);
    }


    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
