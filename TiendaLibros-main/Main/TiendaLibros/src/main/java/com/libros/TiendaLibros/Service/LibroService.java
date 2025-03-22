package com.libros.TiendaLibros.Service;

import com.libros.TiendaLibros.Repository.LibroRepository;
import com.libros.TiendaLibros.Repository.UsuarioRepository;
import com.libros.TiendaLibros.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepo;


    public Libro crearLibro(Libro libro){
        return libroRepo.save(libro);
    }

    public void borrarLibro(Long id){
        libroRepo.deleteById(id);
    }

    public List<Libro> listarLibros() {
        return libroRepo.findAll();
    }

    public List<Libro> buscarLibros(String query) {
        return libroRepo.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCaseOrGeneroContainingIgnoreCase(query, query, query);
    }

    public Libro buscarLibroPorId(Long id){
        return libroRepo.findById(id).orElse(null);
    }



    public Libro modificarLibro(Libro libro) {
        Libro libroExistente = libroRepo.findById(libro.getId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAutor(libro.getAutor());
        libroExistente.setGenero(libro.getGenero());

        return libroRepo.save(libroExistente);
    }
}
