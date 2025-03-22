package com.betterwellness.messagingservice.service;

import com.betterwellness.messagingservice.model.Message;
import com.betterwellness.messagingservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void sendChatRequest(Message message) {
        boolean exists = messageRepository.existsBySenderIdAndReceiverId(
                message.getSenderId(), message.getReceiverId()
        );

        if (exists) {
            throw new IllegalStateException("Chat request already exists!");
        }
        messageRepository.save(message);
    }

    public List<Message> getChatRequests() {
        return messageRepository.findAll();
    }
}

