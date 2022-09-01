package com.proyectoViajes.controller;

import com.proyectoViajes.model.Destino;
import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.DestinoRepository;
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
    private DestinoRepository destinoRepository;

    @GetMapping("")
    public List<Destino> destinos(){
        return destinoRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Destino create(@RequestBody Destino destino){
        return destinoRepository.save(destino);
    }

    @PutMapping("/actualizar/{id}")
    public Destino update(@PathVariable Long id, @RequestBody Destino destino){
        Destino destinoDeBD = destinoRepository.findById(id).orElseThrow(RuntimeException::new);
        destinoDeBD.setProvinciaDestino(destino.getProvinciaDestino());
        destinoDeBD.setCiudadDestino(destino.getCiudadDestino());
        destinoDeBD.setDescripcionDestino(destino.getDescripcionDestino());
        destinoDeBD.setIdViaje(destino.getIdViaje());
        return destinoRepository.save(destinoDeBD);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        Destino destinoDeBD = destinoRepository.findById(id).orElseThrow(RuntimeException::new);
        destinoRepository.delete(destinoDeBD);
    }

    @GetMapping("/destinosViaje/{id}")
    public List<Destino> destinosViaje(@PathVariable int id){
        return destinoRepository.destinosViaje(id);
    }
}
