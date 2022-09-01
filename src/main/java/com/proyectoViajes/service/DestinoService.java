package com.proyectoViajes.service;

import com.proyectoViajes.model.Destino;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinoService {

    public void guardar(Destino destino);
    public void eliminar(Destino destino);
    public List<Destino> listar();
    public Destino listDestinoById(long id);
}
