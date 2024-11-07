package nbc_final.gathering.domain.chatmessage.repository;

import nbc_final.gathering.domain.chatsession.entity.ChatSession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatSession, String> {
}