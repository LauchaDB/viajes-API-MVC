package com.proyectoViajes.service;


import com.proyectoViajes.model.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ViajeService {

    public void guardar(Viaje viaje);
    public void eliminar(Viaje viaje);
    public List<Viaje> listar();
    public Viaje listViajeById(long id);
}
