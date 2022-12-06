package com.proyectoViajes.mapper;

import com.proyectoViajes.model.TravelDestinations;
import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.dto.RequestCreateTravelDestinationsDTO;
import com.proyectoViajes.repository.TravelRepository;
import org.springframework.stereotype.Component;

@Component
public class TravelDestinationMapper {

    private final TravelRepository travelRepository;

    public TravelDestinationMapper(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }


    public TravelDestinations requestCreateTravelDestinationDTOToTravelDestinations(RequestCreateTravelDestinationsDTO requestCreateTravelDestinationDTO){
        Travels travel = findTravel(requestCreateTravelDestinationDTO.getIdTravel());

        TravelDestinations travelDestinations = new TravelDestinations();
        travelDestinations.setProvinces(requestCreateTravelDestinationDTO.getProvinces());
        travelDestinations.setCity(requestCreateTravelDestinationDTO.getCity());
        travelDestinations.setDescription(requestCreateTravelDestinationDTO.getDescription());
        travelDestinations.setTravel(travel);
        return travelDestinations;
    }

    private Travels findTravel(String id) {
        return travelRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public RequestCreateTravelDestinationsDTO travelDestinationsToRequestCreateTravelDestinationsDTO(TravelDestinations travelDestinations){
        RequestCreateTravelDestinationsDTO requestCreateTravelDestinationsDTO = new RequestCreateTravelDestinationsDTO();
        requestCreateTravelDestinationsDTO.setProvinces(travelDestinations.getProvinces());
        requestCreateTravelDestinationsDTO.setCity(travelDestinations.getCity());
        requestCreateTravelDestinationsDTO.setDescription(travelDestinations.getDescription());
        requestCreateTravelDestinationsDTO.setIdTravel(String.valueOf(travelDestinations.getTravel().getId()));
        return requestCreateTravelDestinationsDTO;
    }
}
