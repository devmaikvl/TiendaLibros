package com.libros.TiendaLibros.Repository;

import com.libros.TiendaLibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCaseOrGeneroContainingIgnoreCase(String titulo, String autor, String genero);

}