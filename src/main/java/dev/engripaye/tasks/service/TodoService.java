package dev.engripaye.tasks.service;

import dev.engripaye.tasks.dtos.TodoDto;
import dev.engripaye.tasks.entity.Todo;
import dev.engripaye.tasks.entity.User;
import dev.engripaye.tasks.repository.TodoRepository;
import dev.engripaye.tasks.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<TodoDto> listTodos(User user) {
        return todoRepository.findByOwnerOrderByCreatedAtDesc(user)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TodoDto createTodo(User user, TodoDto dto) {
        Todo t = new Todo();
        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setCompleted(dto.isCompleted());
        t.setOwner(user);
        Todo saved = todoRepository.save(t);
        return toDto(saved);
    }

    @Transactional
    public TodoDto updateTodo(User user, Long id, TodoDto dto) {
        Todo t = todoRepository.findByIdAndOwner(id, user)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        t.setTitle(dto.getTitle());
        t.setDescription(dto.getDescription());
        t.setCompleted(dto.isCompleted());
        return toDto(todoRepository.save(t));
    }

    @Transactional
    public void deleteTodo(User user, Long id) {
        Todo t = todoRepository.findByIdAndOwner(id, user)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todoRepository.delete(t);
    }

    private TodoDto toDto(Todo t) {
        return new TodoDto(
                t.getId(),
                t.getTitle(),
                t.getDescription(),
                t.isCompleted()
        );
    }
}
