package com.proyectoViajes.mapper;

import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.Users;
import com.proyectoViajes.model.dto.RequestCreateTravelDTO;
import com.proyectoViajes.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TravelsMapper {

    private final UserRepository userRepository;

    public TravelsMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Travels requestCreateTravelDTOToTravels(RequestCreateTravelDTO requestCreateTravelDTO) {
        Users user = findUser(requestCreateTravelDTO.getIdUser());
        return Travels.builder()
                .name(requestCreateTravelDTO.getName())
                .description(requestCreateTravelDTO.getDescription())
                .users(user)
                .build();
    }

    private Users findUser(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

}
