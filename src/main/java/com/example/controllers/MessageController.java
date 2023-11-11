package com.example.controllers;

import com.example.entity.Message;
import com.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    MessageService messageService;

    @GetMapping("/messages")
    public Iterable<Message> getAllMessages() {
        return messageService.findAll();
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
