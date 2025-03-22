package com.betterwellness.messagingservice.dto;

import com.betterwellness.messagingservice.util.MessageType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO {

    private MessageType type;
    private String content;
    private String sender;
}
