package com.example.service;

import com.example.dataaccess.PersonRepositoryInterface;
import com.example.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PersonServiceTest {

    @MockBean
    PersonRepositoryInterface mockRepo;

    @Autowired
    PersonService uut;

    @Test
    void testGetAllPersons() {
        Iterable<Person> persons = uut.getAllPersons();
        verify(mockRepo, times(1)).findAll();
    }

}