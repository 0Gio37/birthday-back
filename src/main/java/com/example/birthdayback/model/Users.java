package com.example.birthdayback.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "users")
    private Set<Birthday> birthdays;


    public Users(){
        super();
    }

    public Users(Long id, String username, String password, String email) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return "User : [id =" + id + ", username="+ username + ", password=" + password+"email="+email+"]";
    }

    public Set<Birthday> getBirthdays() {
        return birthdays;
    }
}

