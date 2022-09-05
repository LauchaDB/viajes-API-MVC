package com.proyectoViajes.service;

import com.proyectoViajes.model.Destino;
import com.proyectoViajes.model.Usuario;
import com.proyectoViajes.model.Viaje;
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
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(long id) {
        Usuario usuarioDeBD = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        try {
            usuarioRepository.delete(usuarioDeBD);
        }catch(Exception e){
            //Logger.logMsg(1, e.getMessage());
        }
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.isPresent() ? null : optionalUsuario.get();
    }

    @Override
    public Usuario update(long id, Usuario usuario) {
        Usuario usuarioDeBD = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        usuarioDeBD.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDeBD.setEmailUsuario(usuario.getEmailUsuario());
        usuarioDeBD.setPassword(usuario.getPassword());
        return usuarioRepository.save(usuarioDeBD);
    }
}
