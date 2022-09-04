package com.proyectoViajes.service;

import com.proyectoViajes.model.Destino;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinoService {


    public List<Destino> listAll();
    public Destino listDestinoById(long id);
    public Destino update(long id, Destino destino);
    public Destino save(Destino destino);
    public void delete(long id);
    List<Destino> destinosViaje(Long id);
}
