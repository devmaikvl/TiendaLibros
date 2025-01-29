package com.libros.TiendaLibros.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefono;

    @Column(nullable = false)
    private String tipodeusuario; // Puede ser "administrador" o "usuario estándar"

    public Usuario() {
    }

    public Usuario(String nombre, String email, String telefono, String tipodeusuario) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tipodeusuario = tipodeusuario;
    }


}

