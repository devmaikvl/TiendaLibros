package com.libros.TiendaLibros.Controller;

import com.libros.TiendaLibros.Service.UsuarioService;
import com.libros.TiendaLibros.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
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
