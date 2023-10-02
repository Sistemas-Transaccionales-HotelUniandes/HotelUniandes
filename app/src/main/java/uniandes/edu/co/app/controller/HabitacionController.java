package uniandes.edu.co.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.Habitacion;
import uniandes.edu.co.app.repository.HabitacionRepository;
import org.springframework.ui.Model;
@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitacion")
    public String habitaciones(Model model) {
        model.addAttribute("habitacion", habitacionRepository.darHabitaciones());
        return "habitacion";
        
    }

    @GetMapping("/habitacion/{id}")
    public String habitacionID(@PathVariable("id") Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        if(habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        }
        return "redirect:/habitacion";
    }

    @GetMapping("/habitacion/crear")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionNuevo";
    }

    @PostMapping("/habitacion/crear/submit")
    public String habitacionSubmit(@ModelAttribute Habitacion habitacion, Model model) {
        habitacionRepository.insertarHabitacion(habitacion.getTipoHabitacion().getId());
        return "redirect:/habitacion";
    }

    @GetMapping("/habitacion/editar/{id}")
    public String habitacionEditar(@PathVariable("id") Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        if(habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        }
        return "redirect:/habitacion";
    }

    @PostMapping("/habitacion/editar/submit")
    public String habitacionEditarSubmit(@ModelAttribute Habitacion habitacion, @PathVariable("id") Integer id) {
        habitacionRepository.actualizarHabitacion(id, habitacion.getTipoHabitacion().getId());
        return "redirect:/habitacion";
    }

    @GetMapping("/habitacion/eliminar/{id}")
    public String habitacionEliminar(@PathVariable("id") Integer id) {
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitacion";
    }
    
    
}
