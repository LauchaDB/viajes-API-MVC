package com.proyectoViajes.model;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public List<Viaje> travels;

    public Users(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Viaje> getTravels() {
        return travels;
    }

    public void setTravels(List<Viaje> travels) {
        this.travels = travels;
    }
}
