package nbc_final.gathering.domain.chatsession.entity;

import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Document(collection = "chat_sessions")
public class ChatSession {

    @Id
    private String sessionId;          // MongoDB의 기본 ID 필드
    private Long matchingId;            // 매칭 서비스의 matching_id와 연동
    private Long userId1;               // 첫 번째 사용자 ID
    private Long userId2;               // 두 번째 사용자 ID
    private List<ChatMessage> messages = new ArrayList<>(); // 메시지 리스트

    private LocalDateTime createdAt;
    private LocalDateTime lastMessageAt; // 마지막 메시지 시간

    // 생성 메서드
    public static ChatSession createSession(Long matchingId, Long userId1, Long userId2) {
        ChatSession session = new ChatSession();
        session.matchingId = matchingId;
        session.userId1 = userId1;
        session.userId2 = userId2;
        session.createdAt = LocalDateTime.now();
        return session;
    }

    // 메시지 추가 메서드
    public void addMessage(ChatMessage message) {
        this.messages.add(message);
        this.lastMessageAt = message.getTimestamp();
    }

    // Getters and Setters omitted for brevity
}
