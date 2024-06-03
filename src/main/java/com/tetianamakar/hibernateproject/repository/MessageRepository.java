package com.tetianamakar.hibernateproject.repository;

import com.tetianamakar.hibernateproject.entity.Message;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    @Query("select m from Message m where m.message like %:message%")
    List<Message> findByMessageContains(String message);

}
