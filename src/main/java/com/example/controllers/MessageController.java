package com.example.controllers;

import com.example.entities.Message;
import com.example.service.MessageServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class MessageController {

    private final MessageServiceInterface messageService;

    @Autowired
    MessageController(MessageServiceInterface messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }
}
