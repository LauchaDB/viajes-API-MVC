package com.proyectoViajes.controller;

import com.proyectoViajes.model.TravelDestinations;
import com.proyectoViajes.service.DestinationsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/destination")
public class DestinationsController {

    @Autowired
    private DestinationsServiceImp destinationServiceImp;

    @GetMapping("")
    public List<TravelDestinations> allDestinations(){
        return destinationServiceImp.listAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public TravelDestinations create(@RequestBody TravelDestinations destino){
        return destinationServiceImp.save(destino);
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

    @GetMapping("/allDestinations/{id}")
    public List<TravelDestinations> allDestinations(@PathVariable Long id){
        return destinationServiceImp.destinosViaje(id);
    }
}
