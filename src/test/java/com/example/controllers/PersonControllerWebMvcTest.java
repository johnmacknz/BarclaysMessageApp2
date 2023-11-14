package com.example.controllers;

import com.example.entities.Person;
import com.example.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(PersonController.class)
@AutoConfigureMockMvc
class PersonControllerWebMvcTest {
    
    @MockBean
    PersonService mockPersonService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetAllPersons() throws Exception {
        when(mockPersonService.getAllPersons()).thenReturn(createPersonList());

        ResultActions resultActions = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept("application/json")
                        .andExpect(MockMvcResultMatchers.status().isOk()));

        McvResult result = resultActions.andReturn;

        MockHttpServletRequestBuilder requestBuilder = ;
        mockMvc.perform(requestBuilder);

        verify(mockPersonService, times(1)).getAllPersons();
    }

    private Iterable<Person> createPersonList() {
        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = new Person("Katie");
        Person person2 = new Person("John");
        persons.add(person1);
        persons.add(person2);
        return persons;
    }
}