package com.libros.TiendaLibros.Service;

import com.libros.TiendaLibros.model.ReservaDTO;
import com.libros.TiendaLibros.model.Reserva;
import com.libros.TiendaLibros.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepo;

    // Método para crear una reserva
    public ReservaDTO crearReserva(Reserva reserva) {
        Reserva reservaCreada = reservaRepo.save(reserva);
        return convertirAReservaDTO(reservaCreada);
    }

    // Método para borrar una reserva
    public void borrarReserva(Long id) {
        reservaRepo.deleteById(id);
    }

    // Método para listar todas las reservas
    public List<ReservaDTO> listarReservas() {
        List<Reserva> reservas = reservaRepo.findAll();
        return reservas.stream()
                .map(this::convertirAReservaDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar una reserva por su ID
    public ReservaDTO buscarReservaPorId(Long id) {
        Reserva reserva = reservaRepo.findById(id).orElse(null);
        return reserva != null ? convertirAReservaDTO(reserva) : null;
    }

    public List<ReservaDTO> buscarReservasPorUsuarioId(Long usuarioId) {
        List<Reserva> reservas = reservaRepo.findByUsuarioId(usuarioId);
        return reservas.stream()
                .map(reserva -> convertirAReservaDTO(reserva))  // Asumiendo que tienes un método para convertir a DTO
                .collect(Collectors.toList());
    }


    // Método para modificar una reserva
    public ReservaDTO modificarReserva(Reserva reserva) {
        Reserva reservaExistente = reservaRepo.findById(reserva.getId())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reservaExistente.setUsuario(reserva.getUsuario());
        reservaExistente.setLibro(reserva.getLibro());

        Reserva reservaActualizada = reservaRepo.save(reservaExistente);
        return convertirAReservaDTO(reservaActualizada);
    }

    public ReservaDTO convertirAReservaDTO(Reserva reserva) {
        // Obtener el título del libro
        String libroTitulo = reserva.getLibro() != null ? reserva.getLibro().getTitulo() : "Título no disponible";

        return new ReservaDTO(
                reserva.getId(),
                reserva.getUsuario().getId(),  // Solo el ID del usuario
                reserva.getLibro().getId(),    // Solo el ID del libro
                reserva.getFechaReserva(),
                libroTitulo  // Añadir el título del libro al DTO
        );
    }

}
