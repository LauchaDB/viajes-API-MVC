package com.proyectoViajeService.repository;

import com.proyectoViajes.model.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ViajesRepository extends JpaRepository<Viaje, Long>{
}
