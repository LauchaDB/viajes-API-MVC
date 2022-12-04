package com.proyectoViajes.service;


import com.proyectoViajes.model.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ViajeService {

    public Viaje save(Viaje viaje);
    public void delete(long id);
    public Viaje update(long id, Viaje viaje);
    public List<Viaje> findAll();
    public Viaje findById(long id);
}
