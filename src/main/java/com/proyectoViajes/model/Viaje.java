package com.proyectoViajes.model;

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

    private String descripcionViaje;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "viajes")
    public List<Usuario> usuarios = new ArrayList<>();

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
        this.descripcionViaje = descripcionViaje;
    }

    public String getDescripcionViaje() {
        return descripcionViaje;
    }

    public void addUsuario(Usuario usr) {
        usuarios.add(usr);
    }

}
