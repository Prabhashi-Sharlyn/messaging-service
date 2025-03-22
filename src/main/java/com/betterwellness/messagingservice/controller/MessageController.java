package com.betterwellness.messagingservice.controller;

import com.betterwellness.messagingservice.model.Message;
import com.betterwellness.messagingservice.repository.MessageRepository;
import com.betterwellness.messagingservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
}


