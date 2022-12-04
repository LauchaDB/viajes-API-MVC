package com.proyectoViajes.service;

import com.proyectoViajes.model.TravelDestinations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationsService {


    public List<TravelDestinations> listAll();

    public TravelDestinations listDestinationsById(long id);
    public TravelDestinations update(long id, TravelDestinations destino);
    public TravelDestinations save(TravelDestinations destino);

    public void delete(long id);

    List<TravelDestinations> destinosViaje(Long id);
}
