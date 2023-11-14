package com.example.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.beans.ConstructorProperties;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ConstructorProperties({"name"})
    public Person(String name) {
        this.name = name;
    }

    public Person() {};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}