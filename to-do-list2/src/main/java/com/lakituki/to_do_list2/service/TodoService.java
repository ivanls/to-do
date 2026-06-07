package com.lakituki.to_do_list2.service;

import com.lakituki.to_do_list2.model.Todo;
import com.lakituki.to_do_list2.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    /**
     * Actualizar el TODO
     */
    public Todo actualizarTodo(Integer id, Todo todoActualizado){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException( ("Todo no encontrado")));
        todo.setTitulo(todoActualizado.getTitulo());
        todo.setDescripcion(todoActualizado.getDescripcion());
        todo.setCompletado(todoActualizado.getCompletado());

        return todoRepository.save(todo);
    }

    /**
     * Marcar como completado un TODO
     */
    public Todo marcarCompletadoTodo(Integer id, Boolean completado){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Todo no encontrado"));
        todo.setCompletado(completado);
        return todoRepository.save(todo);
    }

    /**
     * Guardar nuevo TODO
     */
    public Todo registrarTodo(Todo todo){
        return todoRepository.save(todo);
    }

    /**
     * Obtener todas las tareas
     */
    public List<Todo> obtenerTodos(){
        return todoRepository.findAll();
    }

    /**
     * Obtener Todo por ID
     */
    public Optional<Todo> obtenerTodoPorId(Integer id){
        return todoRepository.findById(id);
    }

    /**
     * Eliminar un Todo
     */
    public void eliminarTodo(Integer id){
        if (!todoRepository.existsById(id)){
            throw new RuntimeException("Todo no encontrado");
        }
        todoRepository.deleteById(id);
    }
}
