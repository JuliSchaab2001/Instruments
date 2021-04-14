package com.utn.Final.Controllers;

import com.utn.Final.Models.Band;
import com.utn.Final.Services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/band")
public class BandController {

    @Autowired
    private BandService bandService;

    @GetMapping("/")
    public List<Band> getAll(){
        return bandService.getAll();
    }

    @GetMapping("/{id}")
    public Band getById(@PathVariable Integer id){
        return bandService.getById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody  Band band){
        bandService.add(band);
    }

    @PutMapping("/{bandId}/person/{personId}")
    public void addPersonToBand(@PathVariable Integer bandId, @PathVariable Integer personId){
        bandService.addPersonToBand(bandId, personId);
    }

}
