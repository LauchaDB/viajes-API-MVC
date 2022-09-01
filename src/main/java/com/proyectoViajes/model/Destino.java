package com.proyectoViajes.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name= "tbdestinos")
public class Destino {

    @Id
    @Column(name = "id_dest")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idDest;

    @Column(name = "provincia_dest")
    @Enumerated(EnumType.STRING)
    private Provincias provinciaDestino;

    @Column(name = "ciudad_dest")
    private String ciudadDestino;

    @Column(name = "descrip_dest")
    private String descripcionDestino;

    @Column(name = "id_viaje")
    private int idViaje;

    //contructor
    public Destino(){
    }


    //getters and setters
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

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
}
