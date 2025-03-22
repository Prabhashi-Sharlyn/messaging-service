package com.betterwellness.messagingservice.controller;

import com.betterwellness.messagingservice.dto.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("chat.sendMessage")
    @SendTo("/topic/chat")
    public MessageDTO sendMessage(@Payload MessageDTO message) {
        return message;
    }

    @MessageMapping("chat.addUser")
    @SendTo("/topic/chat")
    public MessageDTO addUser(@Payload MessageDTO message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}
