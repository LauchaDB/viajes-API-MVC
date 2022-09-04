package com.proyectoViajes.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name= "tbdestinos")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDest;

    @Enumerated(EnumType.STRING)
    private Provincias provinciaDestino;

    private String ciudadDestino;

    private String descripcionDestino;

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
        return provinciaDestino;
    }

    public void setProvinciaDestino(Provincias provinciaDestino) {
        this.provinciaDestino = provinciaDestino;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDescripcionDestino() {
        return descripcionDestino;
    }

    public void setDescripcionDestino(String descripcionDestino) {
        this.descripcionDestino = descripcionDestino;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
