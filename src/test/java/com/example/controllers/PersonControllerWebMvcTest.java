package com.example.controllers;

import com.example.entities.Person;
import com.example.service.IPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(PersonController.class)
@AutoConfigureMockMvc
public class PersonControllerWebMvcTest {

    @MockBean
    IPersonService personService;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAllPersons()  throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/persons")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(personService, times(1)).getAllPersons();
    }

    @Test
    public void testGetAlPersonFromHttpRequest() throws Exception {

        when(personService.getAllPersons()).thenReturn(createPersonList());

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/persons")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Person[] actualPersons = mapper.readValue(contentAsString, Person[].class);

        assertEquals(3, actualPersons.length);
    }

    private Iterable<Person> createPersonList()  {
        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = new Person("First person");
        Person person2 = new Person("Second person");
        Person person3 = new Person("Third person");
        persons.add(person1);
        persons.add(person3);
        persons.add(person2);
        return persons;
    }
}