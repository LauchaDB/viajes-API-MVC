package com.proyectoViajes.controller;

import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.ViajeRepository;
import com.proyectoViajes.service.ViajeService;
import com.proyectoViajes.service.ViajeServiceImp;
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
    private ViajeServiceImp viajeServiceImp;

    @GetMapping("")
    public List<Viaje> viajes(){
        return viajeServiceImp.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Viaje create(@RequestBody Viaje viaje){
        return viajeServiceImp.save(viaje);
    }

    @PutMapping("/actualizar/{id}")
    public Viaje update(@PathVariable Long id, @RequestBody Viaje viaje){
        return viajeServiceImp.update(id, viaje);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        viajeServiceImp.delete(id);
    }
}