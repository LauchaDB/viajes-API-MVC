package com.proyectoViajeService.service;

import com.proyectoViajeService.repository.ViajesRepository;
import com.proyectoViajes.model.Viaje;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ViajesService {

    @Autowired
    private ViajesRepository viajesRepository;

    public void guardar(Viaje viaje) {
        viajesRepository.save(viaje);
    }

    public void eliminar(Viaje viaje) {
        viajesRepository.delete(viaje);
    }

    public List<Viaje> listar() {
        return viajesRepository.findAll();
    }

    public Viaje listViajeById(long id) {
        Optional<Viaje> optionalViaje = viajesRepository.findById(id);
        return optionalViaje.isEmpty() ? null : optionalViaje.get();
    }
}
