package com.proyectoViajes.controller;

import com.proyectoViajes.model.Users;
import com.proyectoViajes.model.dto.RequestCreateUsersDTO;
import com.proyectoViajes.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("")
    public List<Users> home(){
        return userServiceImpl.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crate")
    public Users create(@RequestBody RequestCreateUsersDTO users){
        return userServiceImpl.save(users);
    }

    @PutMapping("/actualizar/{id}")
    public Users update(@PathVariable Long id, @RequestBody Users users){
        return userServiceImpl.update(id, users);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id){
        userServiceImpl.delete(id);
    }
}
