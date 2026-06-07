package com.lakituki.to_do_list2.repository;

import com.lakituki.to_do_list2.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
