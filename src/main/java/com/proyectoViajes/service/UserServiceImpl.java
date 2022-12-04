package com.proyectoViajes.service;


import com.proyectoViajes.model.Users;
import com.proyectoViajes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void delete(long id) {
        Users usersDeBD = userRepository.findById(id).orElseThrow(RuntimeException::new);
        try {
            userRepository.delete(usersDeBD);
        }catch(Exception e){
            //Logger.logMsg(1, e.getMessage());
        }
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(long id) {
        Optional<Users> optionalUsuario = userRepository.findById(id);
        return optionalUsuario.isPresent() ? null : optionalUsuario.get();
    }

    @Override
    public Users update(long id, Users users) {
        Users usersDeBD = userRepository.findById(id).orElseThrow(RuntimeException::new);
        usersDeBD.setName(users.getName());
        usersDeBD.setName(users.getMail());
        usersDeBD.setPassword(users.getPassword());
        return userRepository.save(usersDeBD);
    }
}
