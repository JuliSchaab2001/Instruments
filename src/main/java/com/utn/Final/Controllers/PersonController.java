package com.utn.Final.Controllers;

import com.utn.Final.Models.Person;
import com.utn.Final.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @PostMapping("/")
    public void add(@RequestBody Person person){
        personService.add(person);
    }

    @GetMapping("/{personId}")
    public Person getById(@PathVariable Integer personId){
        return personService.getById(personId);
    }

    @PutMapping("/{personId}/instrument/{instrumentId}")
    public void addInstrumentToPerson(@PathVariable Integer personId, @PathVariable Integer instrumentId){
        personService.addInstrumentToPerson(personId, instrumentId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        personService.delete(id);
    }




}
