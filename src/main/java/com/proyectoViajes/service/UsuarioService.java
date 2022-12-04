package com.proyectoViajes.service;


import com.proyectoViajes.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    public Users save(Users users);
    public void delete(long id);
    public List<Users> findAll();
    public Users findById(long id);
    public Users update(long id, Users users);
}
