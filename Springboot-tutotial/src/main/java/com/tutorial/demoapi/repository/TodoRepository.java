package com.tutorial.demoapi.repository;

import com.tutorial.demoapi.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}

