package com.example.service;

import com.example.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService implements IPersonService{

    @Override
    public Iterable<Person> getAllPersons() {
        return new ArrayList<>(); // TODO: implement!
    }
}
