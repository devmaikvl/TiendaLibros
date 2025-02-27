package com.libros.TiendaLibros.auth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
     String nombre;
     String username;
     String telefono;
     String password;
}
