package com.example.birthdayback.service;

import com.example.birthdayback.model.Users;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UsersService {
    public Users login(String username, String password);
    public List<Users> getAllUsers();
    public Users save(Users users);
    public Users getUsersById(Long id);
    public Users getUsersByUsername(String username);
}

