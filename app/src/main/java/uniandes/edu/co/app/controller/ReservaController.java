package uniandes.edu.co.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.Reserva;
import uniandes.edu.co.app.repository.ReservaRepository;
import org.springframework.ui.Model;

@Controller
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reserva")
    public String reservas(Model model) {
        model.addAttribute("reserva", reservaRepository.darReservas());
        return "reserva";
        
    }

    @GetMapping("/reserva/{id}")
    public String reservaID(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.darReservaPorId(id);
        if(reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        }
        return "redirect:/reserva";
    }

    @GetMapping("/reserva/crear")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservaNuevo";
    }

    @PostMapping("/reserva/crear/submit")
    public String reservaSubmit(@ModelAttribute Reserva reserva, Model model) {
        reservaRepository.insertarReserva(reserva.getNumNoches(), reserva.getFechaIn(), reserva.getEstado(), reserva.getAcompanantes(), reserva.getPlanConsumo(), reserva.getCliente());
        return "redirect:/reserva";
    }

    @GetMapping("/reserva/editar/{id}")
    public String reservaEditar(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.darReservaPorId(id);
        if(reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        }
        return "redirect:/reserva";
    }

    @PostMapping("/reserva/editar/submit")
    public String reservaEditarSubmit(@ModelAttribute Reserva reserva, @PathVariable("id") Integer id) {
        reservaRepository.actualizarReserva(id, reserva.getNumNoches(), reserva.getFechaIn(), reserva.getEstado(), reserva.getAcompanantes(), reserva.getPlanConsumo(), reserva.getCliente());
        return "redirect:/reserva";
    }

    // Lo siguiente es para los check-in
    @GetMapping("/reserva/checkin")
    public String checkins(Model model) {
        model.addAttribute("reserva", reservaRepository.darCheckins());
        return "reserva";
        
    }

    @GetMapping("/reserva/checkin/hacerCheckIn/")
    public String checkin(Integer id, Model model) {
        reservaRepository.hacerCheckIn(id);
        return "redirect:/reserva";
    }

    @GetMapping("/reserva/checkin/eliminar/{id}")
    public String reservaCheckinEliminar(@PathVariable("id") Integer id, String estado) {
        if(estado.equals("activa")) {
            reservaRepository.eliminarCheckIn(id, "activa");
        }
        return "redirect:/reserva";
    }

    // Lo siguiente es para los check-out
    @GetMapping("/reserva/checkouts")
    public String checkouts(Model model) {
        model.addAttribute("reserva", reservaRepository.darCheckouts());
        return "reserva";
        
    }

    @GetMapping("/reserva/checkout/hacerCheckOut/")
    public String checkout(Integer id, Model model) {
        reservaRepository.hacerCheckOut(id);
        return "redirect:/reserva";
    }

    @GetMapping("/reserva/checkout/eliminar/{id}")
    public String reservaCheckoutEliminar(@PathVariable("id") Integer id, String estado) {
        if(estado.equals("terminada")) {
            reservaRepository.eliminarCheckOut(id, "terminada");
        }
        return "redirect:/reserva";
    }
    

    @GetMapping("/reserva/eliminar/{id}")
    public String reservaEliminar(@PathVariable("id") Integer id) {
        reservaRepository.eliminarReserva(id);
        return "redirect:/reserva";
    }


    
    
}
