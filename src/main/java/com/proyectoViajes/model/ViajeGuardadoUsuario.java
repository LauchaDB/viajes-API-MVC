package com.proyectoViajes.model;

import javax.persistence.*;

@Entity
@Table(name= "tbviajes_guardados_usuarios")
public class ViajeGuardadoUsuario {

    @Id
    @Column(name = "id_viaje_guardado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViajeGuardado;

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "id_viaje")
    private int idViaje;

    public ViajeGuardadoUsuario() {
    }

    public int getIdViajeGuardado() {
        return idViajeGuardado;
    }

    public void setIdViajeGuardado(int idViajeGuardado) {
        this.idViajeGuardado = idViajeGuardado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
}
