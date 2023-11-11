package com.example;

import com.example.entity.Message;

import java.util.ArrayList;
import java.util.Collection;

public class TestUtility {
    public static Iterable<Message> createMessageList()  {
        ArrayList<Message> messages = new ArrayList<>();
        Message message1 = new Message("First message");
        Message message2 = new Message("Second message");
        Message message3 = new Message("Third message");
        messages.add(message1);
        messages.add(message3);
        messages.add(message2);
        return messages;
    }

    public static <T> int getIterableSize(Iterable<T> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection<T>) iterable).size();
        } else {
            int count = 0;
            for (T item : iterable) {
                count++;
            }
            return count;
        }
    }
}
