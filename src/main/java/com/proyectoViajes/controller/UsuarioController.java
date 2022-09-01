package com.proyectoViajes.controller;

import com.proyectoViajes.model.Usuario;
import com.proyectoViajes.model.Viaje;
import com.proyectoViajes.repository.UsuarioRepository;
import com.proyectoViajes.repository.ViajeRepository;
import com.proyectoViajes.service.UsuarioService;
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
    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    public List<Usuario> home(){
        return usuarioRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crate")
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioDeBD = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuarioDeBD.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDeBD.setEmailUsuario(usuario.getEmailUsuario());
        usuarioDeBD.setPassword(usuario.getPassword());
        return usuarioRepository.save(usuarioDeBD);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        Usuario usuarioDeBD = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuarioRepository.delete(usuarioDeBD);
    }
}
