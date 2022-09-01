package com.proyectoViajes.repository;

import com.proyectoViajes.controller.ViajeController;
import com.proyectoViajes.model.Destino;
import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.model.ViajeGuardadoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.List;

public interface ViajeGuardadoUsuarioRepository extends JpaRepository<ViajeGuardadoUsuario, Long> {

    //ViajeController viajeController = new ViajeController();

    default List<ViajeGuardadoUsuario> viajesGuardados(int idUs){
        //List<Viaje> viajes = viajeController.viajes();
        //List<Integer> viajesIds = Collections.singletonList(0);
        List<ViajeGuardadoUsuario> viajesGuardados = findAll();
        viajesGuardados.removeIf(viajeGuardado -> viajeGuardado.getIdUsuario() != idUs);
        return viajesGuardados;
    }
}
