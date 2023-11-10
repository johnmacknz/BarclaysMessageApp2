package com.example.controllerTests.springhttpunittests;

import com.example.controllers.MessageController;
import com.example.entity.Message;
import com.example.services.MessageService;
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

@WebMvcTest(MessageController.class)
@AutoConfigureMockMvc
public class MessageControllerHttpTests {

    @MockBean
    MessageService messageService;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAllMessages()  throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/messages")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(messageService, times(1)).findAll();
    }

    @Test
    public void testGetAlMessageFromHttpRequest() throws Exception {

        when(messageService.findAll()).thenReturn(createMessageList());

        ResultActions resultActions = this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/messages")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Message[] actualMessages = mapper.readValue(contentAsString, Message[].class);

        assertEquals(3, actualMessages.length);
    }

    private Iterable<Message> createMessageList()  {
        ArrayList<Message> messages = new ArrayList<>();
        Message message1 = new Message("First message");
        Message message2 = new Message("Second message");
        Message message3 = new Message("Third message");
        messages.add(message1);
        messages.add(message3);
        messages.add(message2);
        return messages;
    }
}
