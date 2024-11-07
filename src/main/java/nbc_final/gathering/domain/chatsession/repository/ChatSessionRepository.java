package nbc_final.gathering.domain.chatsession.repository;

import nbc_final.gathering.domain.chatmessage.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatSessionRepository extends MongoRepository<ChatMessage, String> {
}