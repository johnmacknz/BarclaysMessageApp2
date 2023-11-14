package com.example.service;

import com.example.entities.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements IMessageService{

    @Override
    public List<Message> getAllMessages() {
        return new ArrayList<>(); // TODO: implement!
    }
}
