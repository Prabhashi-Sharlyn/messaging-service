package com.betterwellness.messagingservice.repository;

import com.betterwellness.messagingservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    boolean existsBySenderIdAndReceiverId(String senderId, String receiverId);
}
