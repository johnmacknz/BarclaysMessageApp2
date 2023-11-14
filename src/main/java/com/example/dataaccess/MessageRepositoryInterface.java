package com.example.dataaccess;

import com.example.entities.Message;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepositoryInterface extends ListCrudRepository<Message, Long> {
}
