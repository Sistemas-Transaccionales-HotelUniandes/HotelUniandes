package uniandes.edu.co.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.Servicio;
import uniandes.edu.co.app.repository.ServicioRepository;
import org.springframework.ui.Model;
@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicio")
    public String servicios(Model model) {
        model.addAttribute("servicio", servicioRepository.darServicios());
        return "servicio";
        
    }

    @GetMapping("/servicio/{id}")
    public String servicioID(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = servicioRepository.darServicio(id);
        if(servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        }
        return "redirect:/servicio";
    }

    @GetMapping("/servicio/crear")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicio/crear/submit")
    public String servicioSubmit(@ModelAttribute Servicio servicio, Model model) {
        servicioRepository.insertarServicio(servicio.getCosto());
        return "redirect:/servicio";
    }

    @GetMapping("/servicio/editar/{id}")
    public String servicioEditar(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = servicioRepository.darServicio(id);
        if(servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        }
        return "redirect:/servicio";
    }

    @PostMapping("/servicio/editar/submit")
    public String servicioEditarSubmit(@ModelAttribute Servicio servicio, @PathVariable("id") Integer id) {
        servicioRepository.actualizarServicio(id, servicio.getCosto());
        return "redirect:/servicio";
    }

    @GetMapping("/servicio/eliminar/{id}")
    public String servicioEliminar(@PathVariable("id") Integer id) {
        servicioRepository.eliminarServicio(id);
        return "redirect:/servicio";
    }


    
}
