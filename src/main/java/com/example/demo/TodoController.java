package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;




@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private List<Todo> todosList = new ArrayList<>();

    public TodoController() {
        todosList = new ArrayList<>();
        todosList.add(new Todo(1, 1, "gym", false));
        todosList.add(new Todo(2, 2, "todo2 ", false));

    }

    @GetMapping()
    public List<Todo> getTodos() {
        return todosList;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        todosList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }
    
    
    @GetMapping("/{todoId}")
    public ResponseEntity<Object> getTodosById(@PathVariable Long todoId) {
       for(Todo todo: todosList){
        if(todo.getId() == todoId){
            return ResponseEntity.ok(todo);
        }
       }

      return new ResponseEntity<>(Map.of("error", "Todo not found", "id", todoId), HttpStatus.NOT_FOUND);

    }
    
    @DeleteMapping("/{todoId}")
    public ResponseEntity<Object> deleteTodo(@PathVariable Long todoId) {
       for(Todo todo: todosList){
        if(todo.getId() == todoId){
            todosList.remove(todo);
            return ResponseEntity.ok(todo);
        }
       }

      return new ResponseEntity<>(Map.of("error", "Todo not found", "id", todoId), HttpStatus.NOT_FOUND);

    }
    
    @PatchMapping("/{todoId}")
    public ResponseEntity<?> updateTodo(@PathVariable Long todoId, @RequestBody Todo updatedTodo) {
       for(Todo todo: todosList){
        if(todo.getId() == todoId){
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
            return ResponseEntity.ok(todo);
        }
       }

      return new ResponseEntity<>(Map.of("error", "Todo not found", "id", todoId), HttpStatus.NOT_FOUND);

    }
}


// <?> is a Java generics placeholder called a wildcard.
// “This ResponseEntity can contain any type of body, I don’t care what it is.”