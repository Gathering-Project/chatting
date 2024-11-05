package nbc_final.gathering.domain.service;

import lombok.RequiredArgsConstructor;
import nbc_final.gathering.domain.repository.ChattingRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChattingService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ChattingRepository chattingRepository;


}