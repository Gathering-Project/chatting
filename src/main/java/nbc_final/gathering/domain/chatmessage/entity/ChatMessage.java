package nbc_final.gathering.domain.chatmessage.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chat_messages")
public class ChatMessage {

    @Id
    private String messageId;       // MongoDB의 기본 ID 필드
    private String sessionId;       // ChatSession과 연동되는 ID
    private Long senderId;          // 메시지를 보낸 사용자 ID
    private String content;         // 메시지 내용
    private LocalDateTime timestamp; // 메시지 전송 시간
    private boolean isRead;         // 읽음 상태

    // 생성 메서드
    public static ChatMessage createMessage(String sessionId, Long senderId, String content) {
        ChatMessage message = new ChatMessage();
        message.sessionId = sessionId;
        message.senderId = senderId;
        message.content = content;
        message.timestamp = LocalDateTime.now();
        message.isRead = false;
        return message;
    }

    // Getters and Setters omitted for brevity
}