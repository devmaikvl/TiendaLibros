package com.libros.TiendaLibros.Controller;

import com.libros.TiendaLibros.Service.UsuarioService;
import com.libros.TiendaLibros.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/usuario/buscar")
    @ResponseBody
    public List<Usuario> buscarUsuariosPorNombre(@RequestParam String nombre) {
        return usuarioService.buscarUsuariosPorNombre(nombre);
    }


    @PostMapping("/usuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void borrarUsuario(@PathVariable Long id){
        usuarioService.borrarUsuario(id);
    }

    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario buscarUsuarioPorId(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PutMapping("/usuario")
    public void modificarUsuario(@RequestBody Usuario usuario){
        usuarioService.modificarUsuario(usuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id); // Asegurar que el ID del usuario es el correcto
        Usuario usuarioModificado = usuarioService.modificarUsuario(usuario);
        return ResponseEntity.ok(usuarioModificado);
    }

}
