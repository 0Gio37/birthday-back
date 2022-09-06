package com.example.birthdayback.controller;

import com.example.birthdayback.model.Birthday;
import com.example.birthdayback.model.Users;
import com.example.birthdayback.service.BirthdayService;
import com.example.birthdayback.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private BirthdayService birthdayService;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Users>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usersService.getAllUsers());
    }

    @GetMapping(value = {"","/{user-ID}"})
    public ResponseEntity<Users> getUserById(@PathVariable("user-ID") Long userId){
        if(usersService.getUsersById(userId) == null ){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(usersService.getUsersById(userId));
        }
    }

    @PostMapping(value = {""})
    public Users createUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("email") String email){
        Users userToCreate  = new Users(null, username, password, email);
        return usersService.save(userToCreate);
    }

    @PostMapping(value = {"","/{user-ID}/birthdays"})
    public ResponseEntity<Birthday> createBirthday(@PathVariable("user-ID") Long userId,
                                                   @RequestParam("date")
                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                        Date date,
                                                   @RequestParam("firstname") String firstname,
                                                   @RequestParam("lastname") String lastname){
        Users currentUser = usersService.getUsersById(userId);
        Birthday birthdayToCreate  = new Birthday(null, date, firstname, lastname, currentUser);
        if(birthdayService.save(birthdayToCreate) == null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(birthdayService.save(birthdayToCreate));
        }
    }

    @PutMapping(value = {"","/{user-ID}/birthdays"})
    public ResponseEntity UpdateBirthday(@RequestParam("id") Long birthdayId,
                                   @RequestParam("date")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                           Date date,
                                   @RequestParam("firstname") String firstname,
                                   @RequestParam("lastname") String lastname ){
        Birthday birthdayToUpdate = birthdayService.getBirthdayById(birthdayId);
        birthdayToUpdate.setDate(date);
        birthdayToUpdate.setFirstname(firstname);
        birthdayToUpdate.setLastname(lastname);
        if( birthdayService.update(birthdayToUpdate) == null){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.ok(birthdayService.update(birthdayToUpdate));
        }
    }

    @DeleteMapping(value = {"","/{user-ID}/birthdays"})
    public void deleteBirthday(@RequestParam("birthday-ID") Long birthdayId){
        birthdayService.delete(birthdayId);
    }

}
