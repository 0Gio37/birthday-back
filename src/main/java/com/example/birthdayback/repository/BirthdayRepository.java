package com.example.birthdayback.repository;

import com.example.birthdayback.model.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Birthday, Long> {

}
