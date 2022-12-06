package com.proyectoViajes.service;

import com.proyectoViajes.mapper.TravelsMapper;
import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.dto.RequestCreateTravelDTO;
import com.proyectoViajes.repository.TravelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImp implements TravelService {

    private final TravelRepository travelRepository;
    private final TravelsMapper travelsMapper;

    public TravelServiceImp(TravelRepository travelRepository, TravelsMapper travelsMapper) {
        this.travelRepository = travelRepository;
        this.travelsMapper = travelsMapper;
    }

    @Override
    public Travels createTravel(RequestCreateTravelDTO travels) {
        Travels travel = travelsMapper.requestCreateTravelDTOToTravels(travels);
        return travelRepository.save(travel);
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
    public List<RequestCreateTravelDTO> findAll() {
        List<RequestCreateTravelDTO> listRequestCreateTravelDTO = travelsMapper.listTravelsToListRequestCreateTravelDTO(travelRepository.findAll());
        return listRequestCreateTravelDTO;
    }

    @Override
    public Travels findById(long id) {
        Optional<Travels> optionalViaje = travelRepository.findById(id);
        return optionalViaje.isPresent() ? null : optionalViaje.get();
    }
}
