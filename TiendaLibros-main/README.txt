Sistema de Gestión de Reservas para una Biblioteca Digital
Universidad Internacional San Isidro Labrador
Escuela de Ingeniería en Sistemas

Proyecto Final: Sistema de Gestión de Reservas para una Biblioteca Digital
(Isb-27) Ingeniería y Utilización de Software
Profesor: Jason Muñoz Rojas

Estudiantes:
Michel Vargas Lira
Jeudy Eduardo Zuñiga González

Año: 2025
Descripción del Sistema
El Sistema de Gestión de Reservas para una Biblioteca Digital es una aplicación web que permite la búsqueda, reserva y gestión de libros. Los usuarios podrán crear una cuenta para ver y administrar sus libros reservados. El sistema está diseñado para tener dos tipos de perfiles:

Perfil Estándar: Solo permite funciones básicas relacionadas con la biblioteca.
Perfil Administrador: Permite crear y administrar usuarios, agregar y eliminar libros, y realizar otras acciones administrativas.
El sistema sigue un modelo cliente-servidor, con un frontend desarrollado en HTML, CSS y JavaScript, y un backend desarrollado en Java.

Tecnologías y Herramientas Utilizadas
Java con Spring: Lenguaje de programación para el backend debido a su robustez, facilidad de integración con bases de datos, pruebas de integridad y seguridad. Además, es multiplataforma y escalable.
HTML/CSS/JavaScript: Tecnologías utilizadas para desarrollar la interfaz gráfica de usuario, creando una experiencia intuitiva y funcional.
PostgreSQL: Base de datos utilizada por su fiabilidad, rendimiento y escalabilidad.
Postman: Herramienta para pruebas de API, realizando solicitudes HTTP al backend sin necesidad de una interfaz gráfica.
IntelliJ IDEA: IDE para trabajar con Java, ofreciendo numerosas herramientas útiles para el desarrollo.
Visual Studio Code: IDE utilizado para desarrollar el frontend con HTML, CSS y JavaScript.

Instrucciones de uso:
1-Descargar todas las carpetas del proyecto.
2-Instalar IntelliJ y el Java JDK 23.
3-Instalar Visual Studio code y agregar la extension Live Server.
4-Instalar PosgreSQL y crear base de datos con el siguiente query:

CREATE DATABASE DBlibro2;

-- Crear la tabla de usuarios
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Crear la tabla de libros
CREATE TABLE libro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    genero VARCHAR(100)
);

-- Crear la tabla de reservas
CREATE TABLE reserva (
    id SERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    libro_id BIGINT NOT NULL,
    fecha_reserva DATE NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_libro FOREIGN KEY (libro_id) REFERENCES libro(id)
);


-- Insertar usuarios
INSERT INTO usuario (nombre, username, telefono, password, role)
VALUES
    ('Administrador', 'admin', '987654321', '$2a$10$U6XoYtXeESwHmGTAWbX6T.dHQf9XmyT0l2rliWfqO4H4C5A4qgGs2', 'ADMIN');
    ('Usuario Standard', 'user', '987654321', '$2a$10$WIT2lf2jsPZ5C/jKZzf3G.LpueTtt9cM9IXXRgKLhqruNiR/gs7Em', 'USER');


-- Insertar libros
INSERT INTO libro (titulo, autor, genero)
VALUES
    ('Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico'),
    ('1984', 'George Orwell', 'Distopía'),
    ('El gran Gatsby', 'F. Scott Fitzgerald', 'Ficción'),
    ('Orgullo y prejuicio', 'Jane Austen', 'Romántico'),
    ('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Aventura'),
    ('Matar a un ruiseñor', 'Harper Lee', 'Drama'),
    ('La sombra del viento', 'Carlos Ruiz Zafón', 'Misterio'),
    ('Crimen y castigo', 'Fiódor Dostoyevski', 'Psicológico'),
    ('Fahrenheit 451', 'Ray Bradbury', 'Ciencia ficción'),
    ('El alquimista', 'Paulo Coelho', 'Filosofía');


5- Ejecutar base de datos, ejecutar programa en IntelliJ, y abrir pagina web con visual studio code, ejecutamos login.html (TiendaLibros-main\Main\TiendaLibros\src\main\resources\static\login.html) con live server.
Usuarios predeterminados: 
admin  clave: Password001
user   clave: Password002
