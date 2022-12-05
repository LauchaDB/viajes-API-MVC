package com.proyectoViajes.service;

import com.proyectoViajes.model.TravelDestinations;
import com.proyectoViajes.repository.DestinationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationsServiceImp implements DestinationsService {

    @Autowired
    private DestinationsRepository destinationsRepository;


    @Override
    public List<TravelDestinations> listAll() {
        return destinationsRepository.findAll();
    }

  /*  @Override
    public TravelDestinations listDestinationsById(long id) {
        Optional<TravelDestinations> destination = destinationsRepository.findById(id);
        return destination.isPresent() ? null : destination.get();
    }*/

    @Override
    public TravelDestinations update(long id, TravelDestinations destinationData) {
        TravelDestinations destination = destinationsRepository.findById(id).orElseThrow(RuntimeException::new);
        destination.setProvinces(destinationData.getProvinces());
        destination.setCity(destinationData.getCity());
        destination.setDescription(destinationData.getDescription());
        destination.setTravel(destinationData.getTravel());
        return destinationsRepository.save(destination);
    }

    @Override
    public TravelDestinations save(TravelDestinations destino) {
        return destinationsRepository.save(destino);
    }

    @Override
    public void delete(long id) {
        TravelDestinations destinoDeBD = destinationsRepository.findById(id).orElseThrow(RuntimeException::new);
        try {
            destinationsRepository.delete(destinoDeBD);
        }catch(Exception e){
            //Logger.logMsg(1, e.getMessage());
        }

    }

    @Override
    public List<TravelDestinations> destinosViaje(Long id) {
        List<TravelDestinations> destinos = destinationsRepository.findAll();
        destinos.removeIf(destino -> destino.getTravel().getId() != id);
        return destinos;
    }


}
