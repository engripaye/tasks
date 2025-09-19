package dev.engripaye.tasks.repository;

import dev.engripaye.tasks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Todo extends JpaRepository<Todo, Long> {

    List<Todo> findByOwnerOrderByCreatedAtDesc(User owner);
    Optional<Todo> findByIdAndOwner(Long id, User owner);
}
