package com.example.services;

import com.example.dataaccess.MessageRepository;
import com.example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MessageServiceImp implements MessageService{
    private MessageRepository messageRepository;
    @Override
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
