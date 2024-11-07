package nbc_final.gathering.domain.chatsession.service;

import lombok.RequiredArgsConstructor;
import nbc_final.gathering.domain.chatmessage.entity.ChatMessage;
import nbc_final.gathering.domain.chatsession.entity.ChatSession;
import nbc_final.gathering.domain.chatsession.repository.ChatSessionRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatService {

    private final ChatSessionRepository chatSessionRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final RabbitTemplate rabbitTemplate;
    private final SimpMessagingTemplate messagingTemplate;

    // 채팅 세션 생성, 매칭Id를 기반으로 세션을 생성
    @Transactional
    public ChatSession createChatSession(Long matchingId, Long userId1, Long userId2) {
        ChatSession session = ChatSession.createSession(matchingId, userId1, userId2);
        return chatSessionRepository.save(session);
    }

    // 메세지를 전송하고 MongoDB에 저장, STOMP를 통해 실시간 전송
    @Transactional
    public ChatMessage sendMessage (String sessionId, Long senderId, String content) {
        // 메세지 생성 및 저장
        ChatMessage message = ChatMessage.createMessage(sessionId, senderId, content);
        chatMessageRepository.save(message);

        // RabbitMQ로 메세지 전송
        rabbitTemplate.convertAndSend("chat-exchange", "chat.message", message);

        // STOMP를 통해 실시간 메세지 전송
        String destination = "/topic/chat/" + sessionId;
        messagingTemplate.convertAndSend(destination, message);

        return message;
    }

    // 메세지 읽음 상태를 업데이트
    @Transactional
    public void updateMessageReadStatus(String messageId) {
        Optional<ChatMessage> messageOptional = chatMessageRepository.findById(messageId);
        if(messageOptional.isPresent()) {
            ChatMessage message = messageOptional.get();
            message.setRead(true);
            chatMessageRepository.save(message);
        }
    }

}