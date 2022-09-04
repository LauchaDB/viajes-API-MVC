package com.proyectoViajes.service;

import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeServiceImp implements ViajeService{

    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public void guardar(Viaje viaje) {
        viajeRepository.save(viaje);
    }

    @Override
    public void eliminar(Viaje viaje) {
        viajeRepository.delete(viaje);
    }

    @Override
    public List<Viaje> listar() {
        return viajeRepository.findAll();
    }

    @Override
    public Viaje listViajeById(long id) {
        Optional<Viaje> optionalViaje = viajeRepository.findById(id);
        return optionalViaje.isPresent() ? null : optionalViaje.get();
    }
}
