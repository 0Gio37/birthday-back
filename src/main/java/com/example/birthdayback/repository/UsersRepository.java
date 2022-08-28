package com.example.birthdayback.repository;

import com.example.birthdayback.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users>findByUsernameAndPassword(String username, String password);
}

