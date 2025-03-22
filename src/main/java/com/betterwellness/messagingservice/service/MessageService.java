package com.betterwellness.messagingservice.service;

import com.betterwellness.messagingservice.model.Message;
import com.betterwellness.messagingservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void sendChatRequest(Message message) {
        boolean exists = messageRepository.existsBySenderIdAndReceiverIdAndBookingStatus(
                message.getSenderId(), message.getReceiverId(), "PENDING");

        if (exists) {
            throw new IllegalStateException("Chat request already exists!");
        }
        messageRepository.save(message);
    }

    public List<Message> getChatRequests() {
        return messageRepository.findAll();
    }

    public boolean updateBookingStatus(String senderId, String receiverId, String status) {
        Optional<Message> message = messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
        if (message.isPresent()) {
            message.get().setBookingStatus(status);
            messageRepository.save(message.get());
            return true;
        }
        return false;
    }

}

