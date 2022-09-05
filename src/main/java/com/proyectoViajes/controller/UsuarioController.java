package com.proyectoViajes.controller;

import com.proyectoViajes.model.Usuario;
import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.UsuarioRepository;
import com.proyectoViajes.repository.ViajeRepository;
import com.proyectoViajes.service.UsuarioService;
import com.proyectoViajes.service.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImp usuarioServiceImp;

    @GetMapping("")
    public List<Usuario> home(){
        return usuarioServiceImp.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crate")
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioServiceImp.save(usuario);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioServiceImp.update(id, usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        usuarioServiceImp.delete(id);
    }
}
