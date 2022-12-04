package com.proyectoViajes.repository;

import com.proyectoViajes.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsuarioRepository extends JpaRepository<Users, Long> {
}
