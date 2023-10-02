package uniandes.edu.co.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.TipoUsuario;
import uniandes.edu.co.app.repository.TipoUsuarioRepository;

import org.springframework.ui.Model;
@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tipoUsuario")
    public String tipoUsuarios(Model model) {
        model.addAttribute("tipoUsuario", tipoUsuarioRepository.darTipoUsuarios());
        return "tipoUsuario";
        
    }
    
    @GetMapping("/tipoUsuario/{id}")
    public String tipoUsuarioID(@PathVariable("id") Integer id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(id);
        if(tipoUsuario != null) {
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tipoUsuarioEditar";
        }
        return "redirect:/tipoUsuario";
    }

    @GetMapping("/tipoUsuario/crear")
    public String tipoUsuarioForm(Model model) {
        model.addAttribute("tipoUsuario", new TipoUsuario());
        return "tipoUsuarioNuevo";
    }

    @PostMapping("/tipoUsuario/crear/submit")
    public String tipoUsuarioSubmit(@ModelAttribute TipoUsuario tipoUsuario, Model model) {
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getTipo());
        return "redirect:/tipoUsuario";
    }

    @GetMapping("/tipoUsuario/editar/{id}")
    public String tipoUsuarioEditar(@PathVariable("id") Integer id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(id);
        if(tipoUsuario != null) {
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tipoUsuarioEditar";
        }
        return "redirect:/tipoUsuario";
    }

    @PostMapping("/tipoUsuario/editar/submit")
    public String tipoUsuarioEditarSubmit(@ModelAttribute TipoUsuario tipoUsuario, @PathVariable("id") Integer id) {
        tipoUsuarioRepository.actualizarTipoUsuario(id, tipoUsuario.getTipo());
        return "redirect:/tipoUsuario";
    }

    @GetMapping("/tipoUsuario/eliminar/{id}")
    public String tipoUsuarioEliminar(@PathVariable("id") Integer id) {
        tipoUsuarioRepository.eliminarTipoUsuario(id);
        return "redirect:/tipoUsuario";
    }

    
}
