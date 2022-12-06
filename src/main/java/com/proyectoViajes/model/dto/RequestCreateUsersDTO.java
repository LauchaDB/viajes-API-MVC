package com.proyectoViajes.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestCreateUsersDTO {

    private String name;
    private String mail;
    private String password;

    public RequestCreateUsersDTO(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public RequestCreateUsersDTO() {
    }
}
