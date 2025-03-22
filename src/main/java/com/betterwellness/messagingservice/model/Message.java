package com.betterwellness.messagingservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages",
        uniqueConstraints = @UniqueConstraint(columnNames = {"sender_id", "receiver_id", "booking_status"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_id", nullable = false)
    private String senderId;

    @Column(name = "receiver_id", nullable = false)
    private String receiverId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "session", nullable = false)
    private String session;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus = "PENDING";
}

