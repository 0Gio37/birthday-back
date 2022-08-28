package com.example.birthdayback.service;

import com.example.birthdayback.model.Birthday;

import java.util.List;

public interface BirthdayService {
    public List<Birthday> getAllBirthdays();
    public List<Birthday> getBirthdaysByUserId(Long userId);
    public Birthday save(Birthday birthday);
    public void delete(Long id);
    public Birthday getBirthdayById(Long id);
}
