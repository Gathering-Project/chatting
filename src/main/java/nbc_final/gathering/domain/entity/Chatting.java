package nbc_final.gathering.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "chattings")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chatting extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatting_id")
    private Long id;
    private Long userId1;
    private Long userId2;

    public static Chatting createChatting(Long userId1, Long userId2){
        Chatting chatting = new Chatting();
        chatting.userId1 = userId1;
        chatting.userId2 = userId2;
        return chatting;
    }

}