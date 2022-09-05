package com.proyectoViajes.service;


import com.proyectoViajes.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    public Usuario save(Usuario usuario);
    public void delete(long id);
    public List<Usuario> findAll();
    public Usuario findById(long id);
    public Usuario update(long id,Usuario usuario);
}
