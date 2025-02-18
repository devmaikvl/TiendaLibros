package com.libros.TiendaLibros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties({"reservas", "contrasena"})
    private Usuario usuario;

    @ManyToOne
    @JsonIgnoreProperties("reservas")
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    private LocalDate fechaReserva;

    public Reserva() {
    }

    public Reserva(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
    }

    // Asignar la fecha automáticamente antes de persistir la entidad
    @PrePersist
    public void prePersist() {
        if (fechaReserva == null) {
            this.fechaReserva = LocalDate.now();  // Asigna la fecha actual si no se proporciona
        }
    }
}
