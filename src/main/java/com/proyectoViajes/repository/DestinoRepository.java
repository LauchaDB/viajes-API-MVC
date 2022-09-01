package com.proyectoViajes.repository;

import com.proyectoViajes.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DestinoRepository extends JpaRepository<Destino, Long> {

    default List<Destino> destinosViaje(int idViaje){
        List<Destino> destinos = findAll();
        destinos.removeIf(destino -> destino.getIdViaje() != idViaje);
        return destinos;
    }
}
