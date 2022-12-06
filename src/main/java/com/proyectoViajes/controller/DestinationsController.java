package com.proyectoViajes.controller;

import com.proyectoViajes.model.TravelDestinations;
import com.proyectoViajes.model.dto.RequestCreateTravelDestinationsDTO;
import com.proyectoViajes.service.DestinationsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/destinos")
public class DestinationsController {

    @Autowired
    private DestinationsServiceImp destinationServiceImp;

    @GetMapping("")
    public ResponseEntity<List<TravelDestinations>> destinos(){
        return new ResponseEntity<>(destinationServiceImp.listAll(),null, HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public ResponseEntity<TravelDestinations> create(@RequestBody RequestCreateTravelDestinationsDTO destinoDTO){
        return new ResponseEntity<>(destinationServiceImp.createTravelDestinations(destinoDTO), null, HttpStatus.OK) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TravelDestinations> update(@PathVariable Long id, @RequestBody TravelDestinations destino){
        return new ResponseEntity<>(destinationServiceImp.update(id, destino), null, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        destinationServiceImp.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allTravels/{id}")
    public ResponseEntity<List<TravelDestinations>> destinosViaje(@PathVariable Long id){
        return new ResponseEntity<>(destinationServiceImp.destinosViaje(id), null, HttpStatus.OK) ;
    }
}
