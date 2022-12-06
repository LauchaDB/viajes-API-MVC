package com.proyectoViajes.mapper;

import com.proyectoViajes.model.Travels;
import com.proyectoViajes.model.Users;
import com.proyectoViajes.model.dto.RequestCreateTravelDTO;
import com.proyectoViajes.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TravelsMapper {

    private final UserRepository userRepository;

    public TravelsMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Travels requestCreateTravelDTOToTravels(RequestCreateTravelDTO requestCreateTravelDTO) {
        Users user = findUser(requestCreateTravelDTO.getIdUser());
        Travels travel = new Travels();
        travel.setName(requestCreateTravelDTO.getName());
        travel.setDescription(requestCreateTravelDTO.getDescription());
        travel.setUsers(user);
        return travel;
    }

    private Users findUser(String id) {
        return userRepository.findById(Long.parseLong(id)).orElse(null);
    }

    public RequestCreateTravelDTO travelsToRequestCreateTravelDTO(Travels travels){
        RequestCreateTravelDTO requestCreateTravelDTO = new RequestCreateTravelDTO();
        requestCreateTravelDTO.setName(travels.getName());
        requestCreateTravelDTO.setDescription(travels.getDescription());
        requestCreateTravelDTO.setIdUser(String.valueOf(travels.getUsers().getId()));
        return requestCreateTravelDTO;
    }

    public List<RequestCreateTravelDTO> listTravelsToListRequestCreateTravelDTO(List<Travels> listTravels){
        List<RequestCreateTravelDTO> listRequestCreateTravelDTO = new ArrayList<>();
        for (Travels travel: listTravels) {
            listRequestCreateTravelDTO.add(travelsToRequestCreateTravelDTO(travel));
        }
        return listRequestCreateTravelDTO;
    }

}
