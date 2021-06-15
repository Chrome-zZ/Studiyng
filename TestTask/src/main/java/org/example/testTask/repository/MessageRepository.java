package org.example.testTask.repository;

import org.example.testTask.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * FROM messages WHERE user_login = :login ORDER BY ID DESC LIMIT 10", nativeQuery = true)
    List<Message> findLast10Messages(@Param("login") String login);
}