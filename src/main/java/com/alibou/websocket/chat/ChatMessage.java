package com.alibou.websocket.chat;

import lombok.*;

// ChatMessage.java
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String chatId; // Nuevo campo para identificar la sala
}
