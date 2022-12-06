package com.proyectoViajes.controller;

import com.proyectoViajes.model.Users;
import com.proyectoViajes.model.dto.RequestCreateUsersDTO;
import com.proyectoViajes.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("")
    public ResponseEntity<List<Users>> home(){
        return new ResponseEntity<>(userServiceImpl.findAll(), null, HttpStatus.OK) ;
    }

    @PostMapping("/crate")
    public ResponseEntity<Users> create(@RequestBody RequestCreateUsersDTO users){
        return new ResponseEntity<>(userServiceImpl.save(users), null, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users users){
        return new ResponseEntity<>(userServiceImpl.update(id, users), null, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
