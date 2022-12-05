package com.proyectoViajes.controller;

import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.dto.CreateRequestDTO;
import com.proyectoViajes.service.TravelServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    private TravelServiceImp travelServiceImp;

    @GetMapping("/allTravels")
    public List<Travels> allTravels(){
        return travelServiceImp.findAll();
    }

    @PostMapping("/create")
    public Travels create(@RequestBody CreateRequestDTO travels){
        Travels travel = travelServiceImp.createTravel(travels);
        return travel;
    }

    @PutMapping("/update/{id}")
    public Travels update(@PathVariable Long id, @RequestBody Travels travels){
        return travelServiceImp.update(id, travels);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        travelServiceImp.delete(id);
    }
}