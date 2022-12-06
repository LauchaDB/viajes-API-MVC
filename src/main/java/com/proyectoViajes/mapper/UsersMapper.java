package com.proyectoViajes.mapper;

import com.proyectoViajes.model.Users;
import com.proyectoViajes.model.dto.RequestCreateUsersDTO;

public class UsersMapper {

    public Users requestCreateUsersDTOToUser(RequestCreateUsersDTO requestCreateUsersDTO){
        Users user = new Users();
        user.setName(requestCreateUsersDTO.getName());
        user.setMail(requestCreateUsersDTO.getMail());
        user.setPassword(requestCreateUsersDTO.getPassword());
        return user;
    }

    public RequestCreateUsersDTO usersToRequestCreateUsersDTO(Users user){
        RequestCreateUsersDTO requestCreateUsersDTO = new RequestCreateUsersDTO();
        requestCreateUsersDTO.setName(user.getName());
        requestCreateUsersDTO.setMail(user.getMail());
        requestCreateUsersDTO.setPassword(user.getPassword());
        return requestCreateUsersDTO;
    }
}
