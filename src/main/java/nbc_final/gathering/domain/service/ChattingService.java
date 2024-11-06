import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {

    private final RabbitTemplate rabbitTemplate;

    public ChatMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String senderId, String receiverId, String content) {
        ChatMessage message = new ChatMessage(senderId, receiverId, content);
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
        System.out.println("Message sent: " + content);
    }
}