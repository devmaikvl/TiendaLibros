package com.libros.TiendaLibros.Service;

import com.libros.TiendaLibros.Repository.ReservaRepository;
import com.libros.TiendaLibros.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepo;

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    public void borrarReserva(Long id) {
        reservaRepo.deleteById(id);
    }

    public List<Reserva> listarReservas() {
        return reservaRepo.findAll();
    }

    public Reserva buscarReservaPorId(Long id) {
        return reservaRepo.findById(id).orElse(null);
    }

    public Reserva modificarReserva(Reserva reserva) {
        Reserva reservaExistente = reservaRepo.findById(reserva.getId())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reservaExistente.setUsuario(reserva.getUsuario());
        reservaExistente.setLibro(reserva.getLibro());

        return reservaRepo.save(reservaExistente);
    }
}
