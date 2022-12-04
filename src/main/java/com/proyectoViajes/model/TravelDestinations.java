package com.proyectoViajes.model;


import lombok.Data;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@Table(name= "travelDestinations")
public class TravelDestinations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    private Provinces provinces;

    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "travel")
    private Travels travel;

    public TravelDestinations() { }
}
