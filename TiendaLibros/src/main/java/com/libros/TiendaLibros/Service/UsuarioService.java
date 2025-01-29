package com.libros.TiendaLibros.Service;

import com.libros.TiendaLibros.Repository.UsuarioRepository;
import com.libros.TiendaLibros.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepo;

    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public void borrarUsuario(Long id){
        usuarioRepo.deleteById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepo.findById(id).orElse(null);
    }

    public Usuario modificarUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
        return usuario;
    }

    public Usuario modificarUsuario2(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepo.findById(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setTipodeusuario(usuario.getTipodeusuario());

        return usuarioRepo.save(usuarioExistente);
    }
}
