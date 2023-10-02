package uniandes.edu.co.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.Consumo;
import uniandes.edu.co.app.repository.ConsumoRepository;
import org.springframework.ui.Model;
@Controller
public class ConsumoController {
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/consumo")
    public String consumos(Model model) {
        model.addAttribute("consumo", consumoRepository.darConsumos());
        return "consumo";
        
    }

    @GetMapping("/consumo/{id}/{servicio}")
    public String consumoID(@PathVariable("id") Integer id, Model model, @PathVariable("servicio") Integer servicio) {
        Consumo consumo = consumoRepository.darconsumo(id, servicio);
        if(consumo != null) {
            model.addAttribute("consumo", consumo);
            return "consumoEditar";
        }
        return "redirect:/consumo";

    }

    @GetMapping("/consumo/crear")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumo());
        return "consumoNuevo";
    }

    @PostMapping("/consumo/crear/submit")
    public String consumoSubmit(@ModelAttribute Consumo consumo, Model model) {
        consumoRepository.insertarConsumo(consumo.getCuenta().getId().getHabitacion().getId(), consumo.getServicio().getId(), consumo.getCuentaReserva().getId().getReserva().getId());
        return "redirect:/consumo";
    }

    @GetMapping("/consumo/editar/{id}/{servicio}")
    public String consumoEditar(@PathVariable("id") Integer id, Model model, @PathVariable("servicio") Integer servicio) {
        Consumo consumo = consumoRepository.darconsumo(id, servicio);
        if(consumo != null) {
            model.addAttribute("consumo", consumo);
            return "consumoEditar";
        }
        return "redirect:/consumo";
    }

    @PostMapping("/consumo/editar/submit")
    public String consumoEditarSubmit(@ModelAttribute Consumo consumo, @PathVariable("id") Integer id, @PathVariable("servicio") Integer servicio) {
        consumoRepository.actualizarConsumo(id, servicio, consumo.getCuenta().getId().getHabitacion().getId(), consumo.getServicio().getId(), consumo.getCuentaReserva().getId().getReserva().getId());
        return "redirect:/consumo";
    }

    @GetMapping("/consumo/eliminar/{id}/{servicio}")
    public String consumoEliminar(@PathVariable("id") Integer id, Model model, @PathVariable("servicio") Integer servicio) {
        Consumo consumo = consumoRepository.darconsumo(id, servicio);
        if(consumo != null) {
            model.addAttribute("consumo", consumo);
            return "consumoEliminar";
        }
        return "redirect:/consumo";
    }
    
    
    
    
}
