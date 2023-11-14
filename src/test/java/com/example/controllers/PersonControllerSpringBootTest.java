package com.example.controllers;

import com.example.entities.Person;
import com.example.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PersonControllerSpringBootTest {

    @MockBean
    PersonService mockPersonService;

    @Autowired
    PersonController uut;

    @Test
    void testGetAllPersons() {
        Iterable<Person> persons = uut.getAllPersons();
        verify(mockPersonService, times(1)).getAllPersons();
    }
}