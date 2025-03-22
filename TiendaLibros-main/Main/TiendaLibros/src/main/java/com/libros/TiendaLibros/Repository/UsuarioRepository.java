package com.libros.TiendaLibros.Repository;

import com.libros.TiendaLibros.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByusername(String username);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
