package com.betterwellness.messagingservice.repository;

import com.betterwellness.messagingservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    boolean existsBySenderIdAndReceiverIdAndBookingStatus(String senderId, String receiverId, String bookingStatus);
    Optional<Message> findBySenderIdAndReceiverIdAndBookingStatus(String senderId, String receiverId, String bookingStatus);
}
