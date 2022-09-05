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
    private DestinoServiceImp destinoServiceImp;

    @GetMapping("")
    public List<Destino> destinos(){
        return destinoServiceImp.listAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Destino create(@RequestBody Destino destino){
        return destinoServiceImp.save(destino);
    }

    @PutMapping("/actualizar/{id}")
    public Destino update(@PathVariable Long id, @RequestBody Destino destino){
        return destinoServiceImp.update(id, destino);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        destinoServiceImp.delete(id);

    }

    @GetMapping("/destinosViaje/{id}")
    public List<Destino> destinosViaje(@PathVariable Long id){
        return destinoServiceImp.destinosViaje(id);
    }
}
