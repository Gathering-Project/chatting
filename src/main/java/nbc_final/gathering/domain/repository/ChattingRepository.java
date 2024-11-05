package nbc_final.gathering.domain.repository;

import nbc_final.gathering.domain.entity.Chatting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChattingRepository extends JpaRepository<Chatting, Long> {
}