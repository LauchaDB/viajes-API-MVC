package com.proyectoViajes.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name= "users")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;

    private String mail;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tbviajes_guardados_usuarios", joinColumns = {
            @JoinColumn(name = "idUsuario", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "idViaje",
                    nullable = false, updatable = false) })

    public List<Travels> travels;

    public Users(){
    }
}
