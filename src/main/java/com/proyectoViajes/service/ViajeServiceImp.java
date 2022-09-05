package com.proyectoViajes.service;

import com.proyectoViajes.model.Destino;
import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ViajeServiceImp implements ViajeService{

    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public Viaje save(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Override
    public void delete(long id) {
        Viaje viajeDeBD = viajeRepository.findById(id).orElseThrow(RuntimeException::new);
        try {
            viajeRepository.delete(viajeDeBD);
        }catch(Exception e){
            //Logger.logMsg(1, e.getMessage());
        }
    }

    @Override
    public Viaje update(long id, Viaje viaje) {
        Viaje viajeDeBD = viajeRepository.findById(id).orElseThrow(RuntimeException::new);
        viajeDeBD.setNombreViaje(viaje.getNombreViaje());
        viajeDeBD.setDescripcionViaje(viaje.getDescripcionViaje());
        return viajeRepository.save(viajeDeBD);
    }

    @Override
    public List<Viaje> findAll() {
        return viajeRepository.findAll();
    }

    @Override
    public Viaje findById(long id) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(id);
        return optionalViaje.isPresent() ? null : optionalViaje.get();
    }
}
