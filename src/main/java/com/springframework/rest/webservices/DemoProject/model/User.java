package com.springframework.rest.webservices.DemoProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//@Entity
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    private Date birthDate;


    protected User() {

    }

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return String.format("com.springframework.rest.webservices.DemoProject.model.User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }

}
