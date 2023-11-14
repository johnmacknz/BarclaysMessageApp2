package com.example.service;

import com.example.dataaccess.MessageRepositoryInterface;
import com.example.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements MessageServiceInterface {

    private final MessageRepositoryInterface messageRepository;

    @Autowired
    public MessageService(MessageRepositoryInterface messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
