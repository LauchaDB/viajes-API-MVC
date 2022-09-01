package com.proyectoViajes.controller;

import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajeRepository viajeRepository;

    @GetMapping("")
    public List<Viaje> viajes(){
        return viajeRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Viaje create(@RequestBody Viaje viaje){
        return viajeRepository.save(viaje);
    }

    @PutMapping("/actualizar/{id}")
    public Viaje update(@PathVariable Long id, @RequestBody Viaje viaje){
        Viaje viajeDeBD = viajeRepository.findById(id).orElseThrow(RuntimeException::new);
        viajeDeBD.setNombreViaje(viaje.getNombreViaje());
        viajeDeBD.setDescripcionViaje(viaje.getDescripcionViaje());
        viajeDeBD.setId_us(viaje.getId_us());
        return viajeRepository.save(viajeDeBD);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        Viaje viajeDeBD = viajeRepository.findById(id).orElseThrow(RuntimeException::new);
        viajeRepository.delete(viajeDeBD);
    }
}