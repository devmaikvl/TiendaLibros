package com.libros.TiendaLibros;

import com.libros.TiendaLibros.Controller.LibroController;
import com.libros.TiendaLibros.Controller.ReservaController;
import com.libros.TiendaLibros.Controller.UsuarioController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TiendaLibrosApplicationTests {

	@Autowired
	private LibroController libroController;

	@Autowired
	private UsuarioController usuarioController;

	@Autowired
	private ReservaController reservaController;

	@Test
	void contextLoads() {
		assertThat(libroController).isNotNull();
		assertThat(usuarioController).isNotNull();
		assertThat(reservaController).isNotNull();
	}
}
