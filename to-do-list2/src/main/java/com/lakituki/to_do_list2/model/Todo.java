package com.lakituki.to_do_list2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "completado", nullable = false)
    private Boolean completado = false;  // Por defecto: no completado

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    // @PrePersist: Automáticamente asigna fecha al crear
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        if (completado == null) {
            completado = false;
        }
    }
}
