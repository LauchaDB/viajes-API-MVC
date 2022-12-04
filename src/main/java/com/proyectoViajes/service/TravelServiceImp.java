package com.proyectoViajes.service;

import com.proyectoViajes.model.Travels;
import com.proyectoViajes.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImp implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public Travels save(Travels travels) {
        return travelRepository.save(travels);
    }

    @Override
    public void delete(long id) {
        Travels travelsDeBD = travelRepository.findById(id).orElseThrow(RuntimeException::new);
        try {
            travelRepository.delete(travelsDeBD);
        }catch(Exception e){
            //Logger.logMsg(1, e.getMessage());
        }
    }

    @Override
    public Travels update(long id, Travels travels) {
        Travels travel = travelRepository.findById(id).orElseThrow(RuntimeException::new);
        travel.setName(travels.getName());
        travel.setDescription(travels.getDescription());
        return travelRepository.save(travel);
    }

    @Override
    public List<Travels> findAll() {
        return travelRepository.findAll();
    }

    @Override
    public Travels findById(long id) {
        Optional<Travels> optionalViaje = travelRepository.findById(id);
        return optionalViaje.isPresent() ? null : optionalViaje.get();
    }
}
