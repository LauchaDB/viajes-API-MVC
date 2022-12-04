package com.proyectoViajes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name= "tb_travels")
public class Travels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameTravel;

    private String descriptTravel;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "travels")
    @JsonIgnore
    public List<Users> users = new ArrayList<>();

    public Travels(){
    }
}
