package uniandes.edu.co.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.TipoHabitacion;
import uniandes.edu.co.app.repository.TipoHabitacionRepository;
import org.springframework.ui.Model;
@Controller
public class TipoHabitacionController {
    
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tipoHabitacion")
    public String tipoHabitaciones(Model model) {
        model.addAttribute("tipoHabitacion", tipoHabitacionRepository.darTipoHabitaciones());
        return "tipoHabitacion";
        
    }

    @GetMapping("/tipoHabitacion/{id}")
    public String tipoHabitacionID(@PathVariable("id") Integer id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if(tipoHabitacion != null) {
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        }
        return "redirect:/tipoHabitacion";
    }
    
    @GetMapping("/tipoHabitacion/crear")
    public String tipoHabitacionForm(Model model) {
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNuevo";
    }

    @PostMapping("/tipoHabitacion/crear/submit")
    public String tipoHabitacionSubmit(@ModelAttribute TipoHabitacion tipoHabitacion, Model model) {
        tipoHabitacionRepository.inserTipoHabitacion(tipoHabitacion.getTipo(), tipoHabitacion.getDescripcion(), tipoHabitacion.getCapacidad(), tipoHabitacion.getPrecio());
        return "redirect:/tipoHabitacion";
    }

    @GetMapping("/tipoHabitacion/editar/{id}")
    public String tipoHabitacionEditar(@PathVariable("id") Integer id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if(tipoHabitacion != null) {
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        }
        return "redirect:/tipoHabitacion";
    }

    @PostMapping("/tipoHabitacion/editar/submit")
    public String tipoHabitacionEditarSubmit(@ModelAttribute TipoHabitacion tipoHabitacion, @PathVariable("id") Integer id) {
        tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getTipo(), tipoHabitacion.getDescripcion(), tipoHabitacion.getCapacidad(), tipoHabitacion.getPrecio());
        return "redirect:/tipoHabitacion";
    }

    @GetMapping("/tipoHabitacion/eliminar/{id}")
    public String tipoHabitacionEliminar(@PathVariable("id") Integer id) {
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/tipoHabitacion";
    }

}
