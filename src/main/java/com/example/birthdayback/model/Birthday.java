package com.example.birthdayback.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Birthday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Temporal(TemporalType.DATE)
    private Date date;
    private String firstname;
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private Users users;

    public Birthday(){
        super();
    }
    public Birthday(Long id, Date date, String firstname, String lastname, Users users) {
        super();
        this.id = id;
        this.date = date;
        this.firstname = firstname;
        this.lastname = lastname;
        this.users = users;
    }

    public Birthday(Long id, String firstname, String lastname, Users users) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
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

    public void setDate(Date date) {
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
