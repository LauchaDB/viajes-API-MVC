package com.proyectoViajes.controller;

import com.proyectoViajes.model.Users;
import com.proyectoViajes.service.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImp usuarioServiceImp;

    @GetMapping("")
    public List<Users> home(){
        return usuarioServiceImp.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crate")
    public Users create(@RequestBody Users users){
        return usuarioServiceImp.save(users);
    }

    @PutMapping("/actualizar/{id}")
    public Users update(@PathVariable Long id, @RequestBody Users users){
        return usuarioServiceImp.update(id, users);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        usuarioServiceImp.delete(id);
    }
}
