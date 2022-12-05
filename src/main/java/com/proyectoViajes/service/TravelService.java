package com.proyectoViajes.service;


import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.dto.CreateRequestTravelDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelService {

    public Travels createTravel(CreateRequestTravelDTO travels);
    public void delete(long id);
    public Travels update(long id, Travels travels);
    public List<Travels> findAll();
    public Travels findById(long id);
}
