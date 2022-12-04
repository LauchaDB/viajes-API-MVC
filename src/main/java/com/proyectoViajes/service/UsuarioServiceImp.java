package com.proyectoViajes.service;


import com.proyectoViajes.model.Users;
import com.proyectoViajes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Users save(Users users) {
        return usuarioRepository.save(users);
    }

    @Override
    public void delete(long id) {
        Users usersDeBD = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        try {
            usuarioRepository.delete(usersDeBD);
        }catch(Exception e){
            //Logger.logMsg(1, e.getMessage());
        }
    }

    @Override
    public List<Users> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Users findById(long id) {
        Optional<Users> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.isPresent() ? null : optionalUsuario.get();
    }

    @Override
    public Users update(long id, Users users) {
        Users usersDeBD = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usersDeBD.setName(users.getName());
        usersDeBD.setName(users.getMail());
        usersDeBD.setPassword(users.getPassword());
        return usuarioRepository.save(usersDeBD);
    }
}
