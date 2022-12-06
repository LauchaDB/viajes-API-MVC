package com.proyectoViajes.controller;

import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.dto.RequestCreateTravelDTO;
import com.proyectoViajes.service.TravelServiceImp;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<RequestCreateTravelDTO>> viajes(){
        return new ResponseEntity<>(travelServiceImp.findAll(), null, HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public ResponseEntity<Travels> create(@RequestBody RequestCreateTravelDTO travelsDTO){
        return new ResponseEntity<>(travelServiceImp.createTravel(travelsDTO),null,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Travels> update(@PathVariable Long id, @RequestBody Travels travels){
        return new ResponseEntity<>(travelServiceImp.update(id, travels), null, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        travelServiceImp.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}