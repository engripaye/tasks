package dev.engripaye.tasks.controller;

import dev.engripaye.tasks.dtos.TodoDto;
import dev.engripaye.tasks.entity.Todo;
import dev.engripaye.tasks.entity.User;
import dev.engripaye.tasks.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> list(Authentication auth){
        User user = (User) auth.getPrincipal();
        return ResponseEntity.ok(todoService.listTodos(user));
    }

    @PostMapping
    public ResponseEntity<TodoDto> create(Authentication auth, @RequestBody TodoDto dto){
        User user = (User) auth.getPrincipal();
        return ResponseEntity.ok(todoService.createTodo(user, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> update(Authentication authentication, @PathVariable Long id, @RequestBody TodoDto dto){
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(todoService.updateTodo(user, id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Authentication auth, @PathVariable Long id){
        User user = (User) auth.getPrincipal();
        todoService.deleteTodo(user, id);
        return ResponseEntity.noContent().build();
    }
}
