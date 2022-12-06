package com.proyectoViajes.service;


import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.dto.RequestCreateTravelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {

    Travels createTravel(RequestCreateTravelDTO travels);
    void delete(long id);
    Travels update(long id, Travels travels);
    List<RequestCreateTravelDTO> findAll();
    Travels findById(long id);
}
