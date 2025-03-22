package com.betterwellness.messagingservice.controller;

import com.betterwellness.messagingservice.model.Message;
import com.betterwellness.messagingservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/sendRequest")
    public ResponseEntity<String> sendChatRequest(@RequestBody Message message) {
        messageService.sendChatRequest(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/getRequests")
    public ResponseEntity<List<Message>> getChatRequests() {
        List<Message> newMessages = messageService.getChatRequests();
        return ResponseEntity.ok(newMessages);
    }

    @PutMapping("/updateBookingStatus")
    public ResponseEntity<String> updateBookingStatus(@RequestParam String senderId, @RequestParam String receiverId) {

        boolean isUpdated = messageService.updateBookingStatus(senderId, receiverId, "CONFIRMED");

        if (isUpdated) {
            return ResponseEntity.ok("Booking status updated to CONFIRMED successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Failed to update booking status");
        }
    }

}


