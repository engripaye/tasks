package dev.engripaye.tasks.repository;

import dev.engripaye.tasks.entity.Todo;
import dev.engripaye.tasks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<TodoRepository> findByOwnerOrderByCreatedAtDesc(User owner);
    Optional<TodoRepository> findByIdAndOwner(Long id, User owner);
}
