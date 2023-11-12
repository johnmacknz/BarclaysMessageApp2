package com.example;

import com.example.dataaccess.MessageRepository;
import com.example.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Populator {

    private MessageRepository messageRepository;

    @Autowired
    public Populator(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Populator() {}

    public void populate()  {
        Message m1 = new Message("Bryan is the Best!");
        messageRepository.save(m1);

        Message m2 = new Message("So long , and Thanks for all the Fish");
        messageRepository.save(m2);

        Message m3 = new Message("Good luck and Have Fun");
        messageRepository.save(m3);

        Message m4 = new Message("Dave is the Best!");
        messageRepository.save(m4);
    }
}
