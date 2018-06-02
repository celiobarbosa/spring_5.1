package com.journaler.api.controller;

import com.journaler.api.data.Todo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @GetMapping(value="/obtain", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> getTodos() {
        return Arrays.asList(
                new Todo(
                        UUID.randomUUID().toString(),
                        "My first todo",
                        "This is a message for the 1st todo.",
                        System.currentTimeMillis()
                ),
                new Todo(
                        UUID.randomUUID().toString(),
                        "My second todo",
                        "This is a message for the 2nd todo.",
                        System.currentTimeMillis()
                )
        );
    }

    @PutMapping(value="/insert",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Todo insertTodo(@RequestBody Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        return todo;
    }

    @PostMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Todo updateTodo(@RequestBody Todo todo) {
        todo.setTitle(todo.getTitle() + " updated");
        todo.setMessage(todo.getMessage() + " updated");
        todo.setSchedule(System.currentTimeMillis());
        return todo;
    }

    @DeleteMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteTodo(@PathVariable(name = "id") String id) {
        return  false;
    }
}
