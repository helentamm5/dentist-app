package com.cgi.dentistapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter

@Entity
public class Dentist {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    public Dentist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Dentist() {
    }
}
