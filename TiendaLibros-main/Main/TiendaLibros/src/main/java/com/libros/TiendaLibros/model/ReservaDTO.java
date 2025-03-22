package com.libros.TiendaLibros.model;

import java.time.LocalDate;

public class ReservaDTO {

    private Long id;
    private Long usuarioId;
    private Long libroId;
    private LocalDate fechaReserva;
    private String libroTitulo;  // Nuevo campo para el título del libro

    // Constructor
    public ReservaDTO(Long id, Long usuarioId, Long libroId, LocalDate fechaReserva, String libroTitulo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaReserva = fechaReserva;
        this.libroTitulo = libroTitulo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getLibroTitulo() {
        return libroTitulo;
    }

    public void setLibroTitulo(String libroTitulo) {
        this.libroTitulo = libroTitulo;
    }
}
