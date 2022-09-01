package com.proyectoViajes.service;

import com.proyectoViajes.model.Destino;
import com.proyectoViajes.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinoServiceImp implements DestinoService{

    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public void guardar(Destino destino) {
        destinoRepository.save(destino);
    }

    @Override
    public void eliminar(Destino destino) {
        destinoRepository.delete(destino);
    }

    @Override
    public List<Destino> listar() {
        return destinoRepository.findAll();
    }


    @Override
    public Destino listDestinoById(long id) {
        Optional<Destino> optionalDestino = destinoRepository.findById(id);
        return optionalDestino.isEmpty() ? null : optionalDestino.get();
    }
}
