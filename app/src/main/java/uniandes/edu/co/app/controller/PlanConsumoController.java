package uniandes.edu.co.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.PlanConsumo;
import uniandes.edu.co.app.repository.PlanConsumoRepository;
import org.springframework.ui.Model;
@Controller
public class PlanConsumoController {

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping("/planConsumo")
    public String planConsumos(Model model) {
        model.addAttribute("planConsumo", planConsumoRepository.darplanConsumos());
        return "planConsumo";
        
    }

    @GetMapping("/planConsumo/{id}")
    public String planConsumoID(@PathVariable("id") Integer id, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.darplanConsumo(id);
        if(planConsumo != null) {
            model.addAttribute("planConsumo", planConsumo);
            return "planConsumoEditar";
        }
        return "redirect:/planConsumo";
    }

    @GetMapping("/planConsumo/crear")
    public String planConsumoForm(Model model) {
        model.addAttribute("planConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }

    @PostMapping("/planConsumo/crear/submit")
    public String planConsumoSubmit(@ModelAttribute PlanConsumo planConsumo, Model model) {
        planConsumoRepository.insertarplanConsumo(planConsumo.getNombre(), planConsumo.getDescripcion());
        return "redirect:/planConsumo";
    }

    @GetMapping("/planConsumo/editar/{id}")
    public String planConsumoEditar(@PathVariable("id") Integer id, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.darplanConsumo(id);
        if(planConsumo != null) {
            model.addAttribute("planConsumo", planConsumo);
            return "planConsumoEditar";
        }
        return "redirect:/planConsumo";
    }

    @PostMapping("/planConsumo/editar/submit")
    public String planConsumoEditarSubmit(@ModelAttribute PlanConsumo planConsumo, @PathVariable("id") Integer id) {
        planConsumoRepository.actualizarplanConsumo(id, planConsumo.getNombre(), planConsumo.getDescripcion());
        return "redirect:/planConsumo";
    }

    @GetMapping("/planConsumo/eliminar/{id}")
    public String planConsumoEliminar(@PathVariable("id") Integer id) {
        planConsumoRepository.eliminarplanConsumo(id);
        return "redirect:/planConsumo";
    }
    
    
    
}
