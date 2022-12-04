package com.proyectoViajes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "tbviajes")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idViaje;

    private String nombreViaje;

    private String descripViaje;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "viajes")
    @JsonIgnore
    public List<Users> users = new ArrayList<>();

    public Viaje(){
    }

    public void setIdViaje(long idViaje) {
        this.idViaje = idViaje;
    }

    public long getIdViaje() {
        return idViaje;
    }

    public void setNombreViaje(String nombreViaje) {
        this.nombreViaje = nombreViaje;
    }

    public String getNombreViaje() {
        return nombreViaje;
    }

    public void setDescripcionViaje(String descripcionViaje) {
        this.descripViaje = descripcionViaje;
    }

    public String getDescripcionViaje() {
        return descripViaje;
    }

    public void addUsuario(Users usr) {
        users.add(usr);
    }

}
