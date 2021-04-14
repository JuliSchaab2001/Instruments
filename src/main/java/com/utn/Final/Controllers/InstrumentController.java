package com.utn.Final.Controllers;

import com.utn.Final.Models.Instrument;
import com.utn.Final.Models.TypeInstrument;
import com.utn.Final.Services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @GetMapping("/")
    public List<Instrument> getAll(){
        return instrumentService.getAll();
    }

    @GetMapping("/{id}")
    public Instrument getById(@PathVariable  Integer id){
        return instrumentService.getById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody Instrument instrument){
        instrumentService.add(instrument);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        instrumentService.delete(id);
    }

    /*@GetMapping("/")
    public List<Instrument> getByInstrumentType(@RequestParam(required = false) TypeInstrument typeInstrument){
        return  instrumentService.getByInstrumentType(typeInstrument);
    }*/

    @GetMapping("/searchForPrice/")
    public List<Instrument> getByPrice(@RequestParam(required = false) double price){
        return  instrumentService.getByPrice(price);
    }


}
