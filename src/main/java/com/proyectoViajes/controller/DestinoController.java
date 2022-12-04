package com.proyectoViajes.controller;

import com.proyectoViajes.model.TravelDestinations;
import com.proyectoViajes.service.DestinationsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/destinos")
public class DestinoController {

    @Autowired
    private DestinationsServiceImp destinoServiceImp;

    @GetMapping("")
    public List<TravelDestinations> destinos(){
        return destinoServiceImp.listAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public TravelDestinations create(@RequestBody TravelDestinations destino){
        return destinoServiceImp.save(destino);
    }

    @PutMapping("/actualizar/{id}")
    public TravelDestinations update(@PathVariable Long id, @RequestBody TravelDestinations destino){
        return destinoServiceImp.update(id, destino);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        destinoServiceImp.delete(id);

    }

    @GetMapping("/destinosViaje/{id}")
    public List<TravelDestinations> destinosViaje(@PathVariable Long id){
        return destinoServiceImp.destinosViaje(id);
    }
}
