import java.io.Serializable;

public class Chatting implements Serializable {
    private String senderId;
    private String receiverId;
    private String content;
    private String status = "PENDING";

    // Constructor, getters, and setters
    public ChatMessage(String senderId, String receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }

    // Getters and setters omitted for brevity
}