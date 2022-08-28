package com.example.birthdayback.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Birthday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String firstname;
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private Users users;

    public Birthday(){
        super();
    }

    public Birthday(Long id, LocalDate date, String firstname, String lastname, Users users) {
        super();
        this.id = id;
        this.date = date;
        this.firstname = firstname;
        this.lastname = lastname;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @JsonIgnore
    public Users getUser() {
        return users;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "id=" + id +
                ", date=" + date +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", user=" + users +
                '}';
    }
}
