package com.proyectoViajes.repository;

import com.proyectoViajes.model.Travels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travels, Long> {
}
