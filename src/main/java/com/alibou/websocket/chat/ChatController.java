package com.alibou.websocket.chat;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

// ChatController.java
@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/chat/{chatId}") // Ruta dinámica
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage,
            @DestinationVariable String chatId
    ) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser/{chatId}")
    @SendTo("/topic/chat/{chatId}")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            @DestinationVariable String chatId,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        headerAccessor.getSessionAttributes().put("chatId", chatId);
        return chatMessage;
    }
}
