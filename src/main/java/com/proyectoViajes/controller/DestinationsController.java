package com.proyectoViajes.controller;

import com.proyectoViajes.model.TravelDestinations;
import com.proyectoViajes.model.dto.RequestCreateTravelDestinationsDTO;
import com.proyectoViajes.service.DestinationsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/destinos")
public class DestinationsController {

    @Autowired
    private DestinationsServiceImp destinationServiceImp;

    @GetMapping("")
    public List<TravelDestinations> destinos(){
        return destinationServiceImp.listAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public TravelDestinations create(@RequestBody RequestCreateTravelDestinationsDTO destino){
        return destinationServiceImp.createTravelDestinations(destino);
    }

    @PutMapping("/update/{id}")
    public TravelDestinations update(@PathVariable Long id, @RequestBody TravelDestinations destino){
        return destinationServiceImp.update(id, destino);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        destinationServiceImp.delete(id);

    }

    @GetMapping("/allTravels/{id}")
    public List<TravelDestinations> destinosViaje(@PathVariable Long id){
        return destinationServiceImp.destinosViaje(id);
    }
}
