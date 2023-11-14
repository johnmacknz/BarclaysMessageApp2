package com.example.service;

import com.example.dataaccess.PersonRepositoryInterface;
import com.example.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService implements IPersonService{

    PersonRepositoryInterface personRepository;

    @Autowired
    PersonService(PersonRepositoryInterface personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
