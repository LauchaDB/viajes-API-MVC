package com.proyectoViajes.controller;

import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.model.ViajeGuardadoUsuario;
import com.proyectoViajes.repository.ViajeGuardadoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/viajeGuardadoUsuario")
public class ViajeGuardadoUsuarioController {

    @Autowired
    private ViajeGuardadoUsuarioRepository viajeGuardadoUsuarioRepository;

    @GetMapping("/{idUs}")
    public List<ViajeGuardadoUsuario> viajesGuardados(@PathVariable int idUs){
        return viajeGuardadoUsuarioRepository.viajesGuardados(idUs);
    }

}
