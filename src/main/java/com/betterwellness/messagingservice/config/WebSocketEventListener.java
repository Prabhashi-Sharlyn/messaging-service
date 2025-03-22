package com.betterwellness.messagingservice.config;

import com.betterwellness.messagingservice.dto.MessageDTO;
import com.betterwellness.messagingservice.util.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        if (headerAccessor.getSessionAttributes() != null) {
            String username = (String) headerAccessor.getSessionAttributes().get("username");

            if (Objects.nonNull(username)) {
                log.info("User Disconnected : " + username);
                messageSendingOperations.convertAndSend("/topic/chat", MessageDTO.builder()
                        .type(MessageType.LEAVE)
                        .sender(username)
                        .build());
            }
        } else {
            log.warn("Session attributes are NULL! Unable to retrieve username.");
        }
    }
}
