package com.example.birthdayback.service;

import com.example.birthdayback.model.Users;
import com.example.birthdayback.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users login(String username, String password) {
        if(usersRepository.findByUsernameAndPassword(username, password).isPresent()){
            return usersRepository.findByUsernameAndPassword(username, password).get();
        }else {
            return null;
        }
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users save(Users users) {
        if (usersRepository.findAll().contains(users)) {
            return null;
        }else {
            return usersRepository.save(users);
        }
    }

    @Override
    public Users getUsersById(Long id){
        if (usersRepository.findById(id).isPresent()) {
            return usersRepository.findById(id).get();
        }else {
            return null;
        }
    }

    @Override
    public Users getUsersByUsername(String username){
        if (usersRepository.findByUsername(username).isPresent()) {
            return usersRepository.findByUsername(username).get();
        }else {
            return null;
        }
    }
}
