package com.utn.Final.Services;

import com.utn.Final.Models.Band;
import com.utn.Final.Models.Person;
import com.utn.Final.Repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class BandService {

    private BandRepository bandRepository;
    private PersonService personService;

    @Autowired
    public BandService(BandRepository bandRepository, PersonService personService) {
        this.bandRepository = bandRepository;
        this.personService = personService;
    }

    public List<Band> getAll() {
        return bandRepository.findAll();
    }

    public Band getById(Integer id){
        return bandRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void add(Band band){
        bandRepository.save(band);
    }

    public void delete(Integer id){
        bandRepository.deleteById(id);
    }

    public void addPersonToBand(Integer bandId, Integer personId){
        Person person = personService.getById(personId);
        Band band = getById(bandId);
        band.getPersonList().add(person);
        bandRepository.save(band);
    }
}
