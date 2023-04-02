package com.tutorial.demoapi.controller;

import com.tutorial.demoapi.entities.Todo;
import com.tutorial.demoapi.exception.ResourceNotFoundException;
import com.tutorial.demoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
     @Autowired
    private  TodoRepository todoRes;

    @GetMapping // Specification
    public List<Todo> getTodo() { // offset = page * size
        return todoRes.findAll();
    }
    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todos) {
        return todoRes.save(todos);
    }

    @PutMapping("/edit/{id}/complete")
    public ResponseEntity<Todo> completeTodo(@PathVariable(value = "id") Long todoID, @RequestBody Todo todos) {
          Todo completeData = todoRes.findById(todoID).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + todoID));
          completeData.setComplete(todos.isComplete());
          todoRes.save(completeData);
          return ResponseEntity.ok().body(completeData);

    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable(value = "id") Long todoID, @RequestBody Todo todos) {
        Todo updateData = todoRes.findById(todoID).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + todoID));
       updateData.setData(todos.getData());
        todoRes.save(updateData);
        return ResponseEntity.ok().body(updateData);

    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<HttpStatus> deleteTodo(@PathVariable(value = "id") Long todoID) {
        Todo deleteData = todoRes.findById(todoID).orElseThrow(() -> new ResourceNotFoundException("Employee " +
                "not exist with id: " + todoID));
        todoRes.delete(deleteData);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
