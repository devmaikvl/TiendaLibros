package com.libros.TiendaLibros.Controller;
import com.libros.TiendaLibros.Service.ReservaService;
import com.libros.TiendaLibros.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping("/reserva")
    @ResponseBody
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    @PostMapping("/reserva")
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        // La fechaReserva se asigna automáticamente en el modelo, por lo que no es necesario enviarla
        return reservaService.crearReserva(reserva);
    }

    @DeleteMapping("/reserva/{id}")
    public void borrarReserva(@PathVariable Long id) {
        reservaService.borrarReserva(id);
    }

    @GetMapping("/reserva/{id}")
    @ResponseBody
    public Reserva buscarReservaPorId(@PathVariable Long id) {
        return reservaService.buscarReservaPorId(id);
    }
}
