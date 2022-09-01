package com.proyectoViajes.model;

import javax.persistence.*;

@Entity
@Table(name= "tbviajes")
public class Viaje {

    @Id
    @Column(name = "id_viaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idViaje;

    @Column(name = "nombre_viaje")
    private String nombreViaje;

    @Column(name = "descrip_viaje")
    private String descripcionViaje;

    @Column(name = "id_us")
    private int id_us;


    //contructor
    public Viaje(){
    }


    //getters and setters
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
        this.descripcionViaje = descripcionViaje;
    }

    public String getDescripcionViaje() {
        return descripcionViaje;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }

    public int getId_us() {
        return id_us;
    }
}
