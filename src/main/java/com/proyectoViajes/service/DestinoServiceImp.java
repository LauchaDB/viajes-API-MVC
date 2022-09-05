package com.proyectoViajes.service;

import com.proyectoViajes.model.Destino;
import com.proyectoViajes.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DestinoServiceImp implements DestinoService{

    @Autowired
    private DestinoRepository destinoRepository;


    @Override
    public List<Destino> listAll() {
        return destinoRepository.findAll();
    }


    @Override
    public Destino listDestinoById(long id) {
        Optional<Destino> optionalDestino = destinoRepository.findById(id);
        return optionalDestino.isPresent() ? null : optionalDestino.get();
    }

    @Override
    public Destino update(long id, Destino destino) {
        Destino destinoDeBD = destinoRepository.findById(id).orElseThrow(RuntimeException::new);
        destinoDeBD.setProvinciaDestino(destino.getProvinciaDestino());
        destinoDeBD.setCiudadDestino(destino.getCiudadDestino());
        destinoDeBD.setDescripcionDestino(destino.getDescripcionDestino());
        destinoDeBD.setViaje(destino.getViaje());
        return destinoRepository.save(destinoDeBD);
    }

    @Override
    public Destino save(Destino destino) {
        return destinoRepository.save(destino);
    }

    @Override
    public void delete(long id) {
        Destino destinoDeBD = destinoRepository.findById(id).orElseThrow(RuntimeException::new);
        try {
            destinoRepository.delete(destinoDeBD);
        }catch(Exception e){
            //Logger.logMsg(1, e.getMessage());
        }

    }

    @Override
    public List<Destino> destinosViaje(Long id) {
        List<Destino> destinos = destinoRepository.findAll();
        destinos.removeIf(destino -> destino.getViaje().getIdViaje() != id);
        return destinos;
    }


}
