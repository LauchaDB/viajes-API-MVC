package com.proyectoViajes.controller;

import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.dto.RequestCreateTravelDTO;
import com.proyectoViajes.service.TravelServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/travel")
public class TravelController {

    private final TravelServiceImp travelServiceImp;

    public TravelController(TravelServiceImp travelServiceImp) {
        this.travelServiceImp = travelServiceImp;
    }

    @GetMapping("/allTravels")
    public List<RequestCreateTravelDTO> viajes(){
        return travelServiceImp.findAll();
    }

    @PostMapping("/create")
    public Travels create(@RequestBody RequestCreateTravelDTO travels){
        return travelServiceImp.createTravel(travels);
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