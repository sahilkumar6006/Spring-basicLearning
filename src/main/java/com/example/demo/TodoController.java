package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TodoController {

    public static List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
        todos.add(new Todo(1, 1, "gym", false));
        todos.add(new Todo(2, 2, "todo2 ", false));

    }

    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
