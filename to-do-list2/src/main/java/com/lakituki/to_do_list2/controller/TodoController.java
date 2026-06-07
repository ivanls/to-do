package com.lakituki.to_do_list2.controller;

import com.lakituki.to_do_list2.model.Todo;
import com.lakituki.to_do_list2.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * Registrar nuevo Todo
     */
    @PostMapping("/registro")
    public ResponseEntity<Todo> registrarTodo(@RequestBody Todo todo){
        try {
            Todo todoNuevo = todoService.registrarTodo(todo);
            return ResponseEntity.status(HttpStatus.CREATED).body(todoNuevo);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Obtener todos los TODOS
     */
    @GetMapping
    public ResponseEntity<List<Todo>> obtenerTodos(){
        return ResponseEntity.ok(todoService.obtenerTodos());
    }

    /**
     * Obtener TODO por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> obtenerPorId(@PathVariable Integer id){
        return todoService.obtenerTodoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Actualizar un TODO
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> actualizarTodo(
            @PathVariable Integer id,
            @RequestBody Todo todoActualizado
    ){
        try{
            Todo actualizado = todoService.actualizarTodo(id, todoActualizado);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Marcar como completado
     */
    @PutMapping("/{id}/completar")
    public ResponseEntity<Todo> completarTodo(
            @PathVariable Integer id,
            @RequestBody Todo todoCompletado
    ){
        try{
            Todo completado = todoService.marcarCompletadoTodo(id, todoCompletado.getCompletado());
            return  ResponseEntity.ok(completado);
        } catch (RuntimeException e) {
            return  ResponseEntity.notFound().build();
        }
    }

    /**
     * Eliminar un TODO
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarTodo(
            @PathVariable Integer id
    ){
        try{
            todoService.eliminarTodo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
