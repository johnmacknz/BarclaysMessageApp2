package com.example.service;

import com.example.dataaccess.PersonRepositoryInterface;
import com.example.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements PersonServiceInterface {

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
