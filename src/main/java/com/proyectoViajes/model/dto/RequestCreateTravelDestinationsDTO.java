package com.proyectoViajes.model.dto;

import com.proyectoViajes.model.City;
import com.proyectoViajes.model.Provinces;
import com.proyectoViajes.model.Travels;
import lombok.Data;

import javax.persistence.*;

@Data
public class RequestCreateTravelDestinationsDTO {

    private Provinces provinces;

    private City city;

    private String description;

    private String idTravel;

    public RequestCreateTravelDestinationsDTO(Provinces provinces, City city, String description, String idTravel) {
        this.provinces = provinces;
        this.city = city;
        this.description = description;
        this.idTravel = idTravel;
    }

    public RequestCreateTravelDestinationsDTO() {
    }
}
