package com.example.controllers;

import com.example.service.IMessageService;
import com.example.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(MessageController.class)
@AutoConfigureMockMvc
class MessageControllerWebMvcTest {

    @MockBean
    IMessageService mockMessageService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetAllMessages() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/messages");
        mockMvc.perform(requestBuilder);

        verify(mockMessageService, times(1)).getAllMessages();
    }
}