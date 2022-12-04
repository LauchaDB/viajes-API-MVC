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

    @Override
    public TravelDestinations listDestinationsById(long id) {
        return null;
    }

    public TravelDestinations listDestinoById(long id) {
        Optional<TravelDestinations> optionalDestino = destinationsRepository.findById(id);
        return optionalDestino.isPresent() ? null : optionalDestino.get();
    }

    @Override
    public TravelDestinations update(long id, TravelDestinations destino) {
        TravelDestinations destinoDeBD = destinationsRepository.findById(id).orElseThrow(RuntimeException::new);
        destinoDeBD.setProvinces(destino.getProvinces());
        destinoDeBD.setCity(destino.getCity());
        destinoDeBD.setDescription(destino.getDescription());
        destinoDeBD.setTravel(destino.getTravel());
        return destinationsRepository.save(destinoDeBD);
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
