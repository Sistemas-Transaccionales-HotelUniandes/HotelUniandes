package uniandes.edu.co.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.ReservaSalon;
import uniandes.edu.co.app.model.ReservaSpa;
import uniandes.edu.co.app.repository.ReservaSalonRepository;
import uniandes.edu.co.app.repository.ReservaSpaRepository;

import org.springframework.ui.Model;

@Controller
public class ReservaServiciosController {
    @Autowired
    private ReservaSpaRepository reservaSpaRepository;

    @Autowired
    private ReservaSalonRepository reservaSalonRepository;


    @GetMapping("/reservaServicios")
    public String reservas(Model model) {
        model.addAttribute("reservaSpa", reservaSpaRepository.darreservaSpas());
        model.addAttribute("reservaSalon", reservaSalonRepository.darreservaSalones());
        return "reservaServicios";
        
    }
    
    @GetMapping("/reservaServicios/Spa")
    public String reservasSpa(Model model) {
        model.addAttribute("reservaSpa", reservaSpaRepository.darreservaSpas());
        return "reservaSpa";
        
    }

    @GetMapping("/reservaServicios/Salon")
    public String reservasSalon(Model model) {
        model.addAttribute("reservaSalon", reservaSalonRepository.darreservaSalones());
        return "reservaSalon";
        
    }

    @GetMapping("/reservaServicios/Spa/{id}/{cuenta}")
    public String reservaSpaID(@PathVariable("id") Integer id, Model model, @PathVariable("cuenta") Integer cuenta) {
        ReservaSpa reserva = reservaSpaRepository.darreservaSpaPorId(id, cuenta);
        if(reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaSpaEditar";
        }
        return "redirect:/reservaServicios/Spa";

    }

    @GetMapping("/reservaServicios/Salon/{id}/{cuenta}")
    public String reservaSalonID(@PathVariable("id") Integer id, Model model, @PathVariable("cuenta") Integer cuenta) {
        ReservaSalon reserva = reservaSalonRepository.darreservaSalonPorId(id, cuenta);
        if(reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaSalonEditar";
        }
        return "redirect:/reservaServicios/Salon";

    }

    @GetMapping("/reservaServicios/Spa/crear")
    public String reservaSpaForm(Model model) {
        model.addAttribute("reserva", new ReservaSpa());
        return "reservaSpaNuevo";
    }

    @GetMapping("/reservaServicios/Salon/crear")
    public String reservaSalonForm(Model model) {
        model.addAttribute("reserva", new ReservaSalon());
        return "reservaSalonNuevo";
    }

    @PostMapping("/reservaServicios/Spa/crear/submit")
    public String reservaSpaSubmit(@ModelAttribute ReservaSpa reserva, Model model) {
        reservaSpaRepository.insertarreservaSpa(reserva.getId().getSpa().getId(), reserva.getId().getCuenta().getId().getHabitacion().getId(), reserva.getCosto(), reserva.getHoraIn(), reserva.getDia(),  reserva.getCuentaReserva().getId().getReserva().getId());
        return "redirect:/reservaServicios/Spa";
    }

    @PostMapping("/reservaServicios/Salon/crear/submit")
    public String reservaSalonSubmit(@ModelAttribute ReservaSalon reserva, Model model) {
        reservaSalonRepository.insertarreservaSalon(reserva.getId().getSalon().getId(), reserva.getId().getCuenta().getId().getHabitacion().getId(), reserva.getHoraIn(), reserva.getDia(),  reserva.getDuracion(), reserva.getCuentaReserva().getId().getReserva().getId());
        return "redirect:/reservaServicios/Salon";
    }

    @PostMapping("/reservaServicios/Spa/actualizar/submit")
    public String reservaSpaActualizar(@ModelAttribute ReservaSpa reserva, Model model) {
        reservaSpaRepository.actualizarreservaSpa(reserva.getId().getSpa().getId(), reserva.getId().getCuenta().getId().getHabitacion().getId(), reserva.getCosto(), reserva.getHoraIn(), reserva.getDia(),  reserva.getCuentaReserva().getId().getReserva().getId());
        return "redirect:/reservaServicios/Spa";
    }

    @PostMapping("/reservaServicios/Salon/actualizar/submit")
    public String reservaSalonActualizar(@ModelAttribute ReservaSalon reserva, Model model) {
        reservaSalonRepository.actualizarreservaSalon(reserva.getId().getSalon().getId(), reserva.getId().getCuenta().getId().getHabitacion().getId(), reserva.getHoraIn(), reserva.getDia(),  reserva.getDuracion(), reserva.getCuentaReserva().getId().getReserva().getId());
        return "redirect:/reservaServicios/Salon";
    }

    @GetMapping("/reservaServicios/Spa/eliminar/{id}/{cuenta}")
    public String reservaSpaEliminar(@PathVariable("id") Integer id, Model model, @PathVariable("cuenta") Integer cuenta) {
        reservaSpaRepository.eliminarreservaSpa(id, cuenta);
        return "redirect:/reservaServicios/Spa";
    }

    @GetMapping("/reservaServicios/Salon/eliminar/{id}/{cuenta}")
    public String reservaSalonEliminar(@PathVariable("id") Integer id, Model model, @PathVariable("cuenta") Integer cuenta) {
        reservaSalonRepository.eliminarreservaSalon(id, cuenta);
        return "redirect:/reservaServicios/Salon";
    }
    
    
}
