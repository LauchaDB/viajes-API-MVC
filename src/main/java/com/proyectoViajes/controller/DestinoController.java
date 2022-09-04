package com.proyectoViajes.controller;

import com.proyectoViajes.model.Destino;
import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.DestinoRepository;
import com.proyectoViajes.service.DestinoService;
import com.proyectoViajes.service.DestinoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/destinos")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping("")
    public List<Destino> destinos(){
        return destinoService.listAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Destino create(@RequestBody Destino destino){
        return destinoService.save(destino);
    }

    @PutMapping("/actualizar/{id}")
    public Destino update(@PathVariable Long id, @RequestBody Destino destino){
        return destinoService.update(id, destino);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        destinoService.delete(id);

    }

    @GetMapping("/destinosViaje/{id}")
    public List<Destino> destinosViaje(@PathVariable Long id){
        return destinoService.destinosViaje(id);
    }
}
