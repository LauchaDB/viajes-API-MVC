package com.proyectoViajes.model.dto;

public class RequestCreateTravelDTO {

    private String name;
    private String description;
    private String idUser;

    public RequestCreateTravelDTO() {

    }
    public RequestCreateTravelDTO(String name, String description, String idUser) {
        this.name = name;
        this.description = description;
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
