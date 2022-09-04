package com.proyectoViajes.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "tbusuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idUsuario;

    private String nombreUsuario;

    private String emailUsuario;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tbviajes_guardados_usuarios", joinColumns = {
            @JoinColumn(name = "idUsuario", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "idViaje",
                    nullable = false, updatable = false) })
    public List<Viaje> viajes;

    public Usuario(){
    }

     public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void addViajes(Viaje viaje) {
        viajes.add(viaje);
    }
}
