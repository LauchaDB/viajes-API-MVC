package com.proyectoViajes.service;


import com.proyectoViajes.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {

    public void guardar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public List<Usuario> listar();
    public Usuario listUsuarioById(long id);
}
