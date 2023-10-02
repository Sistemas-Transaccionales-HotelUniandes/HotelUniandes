package uniandes.edu.co.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.app.model.Usuario;
import uniandes.edu.co.app.repository.UsuarioRepository;

import org.springframework.ui.Model;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public String usuarios(Model model) {
        model.addAttribute("usuario", usuarioRepository.darUsuarios());
        return "usuario";
        
    }

    @GetMapping("/usuario/{id}")
    public String usuarioID(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioRepository.darUsuarioPorId(id);
        if(usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        }
        return "redirect:/usuario";
    }

    @GetMapping("/usuario/crear")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuario/crear/submit")
    public String usuarioSubmit(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getEmail(), usuario.getDocumento(), usuario.getTipoDocumento(), usuario.getTipoUsuario().getId());
        return "redirect:/usuario";
    }
    
    @GetMapping("/usuario/editar/{id}")
    public String usuarioEditar(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioRepository.darUsuarioPorId(id);
        if(usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        }
        return "redirect:/usuario";
    }

    @PostMapping("/usuario/editar/submit")
    public String usuarioEditarSubmit(@ModelAttribute Usuario usuario, @PathVariable("id") Integer id) {
        usuarioRepository.actualizarUsuario(id, usuario.getNombre(), usuario.getEmail(), usuario.getTipoDocumento(), usuario.getDocumento(), usuario.getTipoUsuario().getId());
        return "redirect:/usuario";
    }

    @GetMapping("/usuario/eliminar/{id}")
    public String usuarioEliminar(@PathVariable("id") Integer id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuario";
    }

}
