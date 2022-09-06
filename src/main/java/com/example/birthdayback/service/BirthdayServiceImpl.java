package com.example.birthdayback.service;


import com.example.birthdayback.model.Birthday;
import com.example.birthdayback.model.Users;
import com.example.birthdayback.repository.BirthdayRepository;
import com.example.birthdayback.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirthdayServiceImpl implements BirthdayService{

    @Autowired
    private BirthdayRepository birthdayRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Birthday> getAllBirthdays() {
        return birthdayRepository.findAll();
    }

    //TODO : check if error
    @Override
    public List<Birthday> getBirthdaysByUserId(Long userId) {
        Optional<Users> currentUser = usersRepository.findById(userId);
        if (currentUser.isPresent()) {
            return (List<Birthday>)currentUser.get().getBirthdays();
        }else {
            return null;
        }
    }

    @Override
    public Birthday update(Birthday birthday){
        if (birthdayRepository.findAll().contains(birthday)) {
            return birthdayRepository.save(birthday);
        } else {
            return null;
        }
    }

    @Override
    public Birthday save(Birthday birthday) {
        if (birthdayRepository.findAll().contains(birthday)) {
            return null;
        } else {
            return birthdayRepository.save(birthday);
        }
    }


    @Override
    public Birthday getBirthdayById (Long id){
        if(birthdayRepository.findById(id).isPresent()){
            return birthdayRepository.findById(id).get();
        }else {
            return null;
        }
    }

    @Override
    public void delete(Long id){
        if(birthdayRepository.findById(id).isPresent()){
            birthdayRepository.delete(birthdayRepository.findById(id).get());
        }
    }
}

