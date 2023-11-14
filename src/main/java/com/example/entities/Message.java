package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String body;

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }
}
