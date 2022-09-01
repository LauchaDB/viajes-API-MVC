package com.proyectoViajes.model;

import javax.persistence.*;

@Entity
@Table(name= "tbusuarios")
public class Usuario {

    @Id
    @Column(name = "id_us")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idUsuario;

    @Column(name = "nombre_us")
    private String nombreUsuario;

    @Column(name = "email_us")
    private String emailUsuario;

    @Column(name = "password_us")
    private String password;


    //constructor vasio
    public Usuario(){
    }


    //getters and setters
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
}
