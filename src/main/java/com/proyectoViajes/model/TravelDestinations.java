package com.proyectoViajes.model;


import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name= "travelDestinations")
public class TravelDestinations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Provinces provinces;

    @Enumerated(EnumType.STRING)
    private City city;

    private String description;

    @OneToOne
    @JoinColumn(name = "travel")
    private Viaje travel;

    public TravelDestinations() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Viaje getTravel() {
        return travel;
    }

    public void setTravel(Viaje travel) {
        this.travel = travel;
    }
}
