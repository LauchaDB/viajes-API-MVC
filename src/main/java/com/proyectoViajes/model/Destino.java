package com.proyectoViajes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name= "tbdestinos")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDest;

    @Enumerated(EnumType.STRING)
    private Provincias provinciaDest;

    private String ciudadDest;

    private String descripDest;

    @OneToOne
    @JoinColumn(name = "viaje")
    private Viaje viaje;

    public Destino(){
    }

    public long getIdDest() {
        return idDest;
    }

    public void setIdDest(long idDest) {
        this.idDest = idDest;
    }

    public Provincias getProvinciaDestino() {
        return provinciaDest;
    }

    public void setProvinciaDestino(Provincias provinciaDest) {
        this.provinciaDest = provinciaDest;
    }

    public String getCiudadDestino() {
        return ciudadDest;
    }

    public void setCiudadDestino(String ciudadDest) {
        this.ciudadDest = ciudadDest;
    }

    public String getDescripcionDestino() {
        return descripDest;
    }

    public void setDescripcionDestino(String descripDest) {
        this.descripDest = descripDest;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
