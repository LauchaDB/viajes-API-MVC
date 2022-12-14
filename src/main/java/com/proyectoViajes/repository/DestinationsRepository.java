package com.proyectoViajes.repository;

import com.proyectoViajes.model.TravelDestinations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DestinationsRepository extends JpaRepository<TravelDestinations, Long> {


}
