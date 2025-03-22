package com.libros.TiendaLibros.Controller;

import com.libros.TiendaLibros.model.ReservaDTO;  // Asegúrate de importar desde el paquete dto
import com.libros.TiendaLibros.Service.ReservaService;
import com.libros.TiendaLibros.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reserva")
    @ResponseBody
    public List<ReservaDTO> listarReservas() {
        // El servicio ya devuelve ReservaDTO, no necesitas hacer el mapeo aquí
        return reservaService.listarReservas();
    }

    @PostMapping("/reserva")
    public ReservaDTO crearReserva(@RequestBody Reserva reserva) {
        ReservaDTO reservaDTO = reservaService.crearReserva(reserva);  // El servicio ya devuelve un ReservaDTO
        return reservaDTO;
    }

    @DeleteMapping("/reserva/{id}")
    public void borrarReserva(@PathVariable Long id) {
        reservaService.borrarReserva(id);
    }

    @GetMapping("/reserva/{id}")
    @ResponseBody
    public ReservaDTO buscarReservaPorId(@PathVariable Long id) {
        ReservaDTO reservaDTO = reservaService.buscarReservaPorId(id);  // El servicio ya devuelve un ReservaDTO
        return reservaDTO;
    }

    @GetMapping("/reserva/usuario/{usuarioId}")
    @ResponseBody
    public List<ReservaDTO> buscarReservasPorUsuarioId(@PathVariable Long usuarioId) {
        return reservaService.buscarReservasPorUsuarioId(usuarioId);
    }

}
