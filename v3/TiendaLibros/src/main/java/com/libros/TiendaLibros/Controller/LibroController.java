package com.libros.TiendaLibros.Controller;

import com.libros.TiendaLibros.Service.LibroService;
import com.libros.TiendaLibros.Service.UsuarioService;
import com.libros.TiendaLibros.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class LibroController {

    @Autowired
    LibroService libroService;

    // Obtener lista de libros
    @GetMapping("/libro")
    @ResponseBody
    public List<Libro> listarLibros(){
        return libroService.listarLibros();
    }

    // Buscar libros por nombre, autor o género
    @GetMapping("/libro/buscar")  // Cambié la ruta a /libro/buscar
    public List<Libro> buscarLibros(@RequestParam String query) {
        return libroService.buscarLibros(query);  // Suponiendo que tu servicio maneja la búsqueda
    }

    // Crear un libro
    @PostMapping("/libro")
    public Libro crearLibro(@RequestBody Libro libro){
        return libroService.crearLibro(libro);
    }

    // Borrar un libro
    @DeleteMapping("/libro/{id}")
    public void borrarLibro(@PathVariable Long id){
        libroService.borrarLibro(id);
    }

    // Buscar un libro por id
    @GetMapping("/libro/{id}")
    @ResponseBody
    public Libro buscarLibroPorId(@PathVariable Long id){
        return libroService.buscarLibroPorId(id);
    }


    @PutMapping("/libro/{id}")
    public ResponseEntity<Libro> modificarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        Libro libroModificado = libroService.modificarLibro(libro);
        return ResponseEntity.ok(libroModificado);
    }
}



