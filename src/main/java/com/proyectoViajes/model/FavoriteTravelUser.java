package com.proyectoViajes.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name= "tbviajes_guardados_usuarios")
public class FavoriteTravelUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int idUser;

    private int idTravel;

    public FavoriteTravelUser() {
    }
}
