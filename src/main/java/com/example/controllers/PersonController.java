package com.example.controllers;

import com.example.entities.Person;
import com.example.service.PersonServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonServiceInterface personService;

    @Autowired
    PersonController(PersonServiceInterface personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public Iterable<Person> getAllPersons() {
        return personService.getAllPersons();
    }
}
