package uniandes.edu.co.app.controller;

import org.springframework.ui.Model;
import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.app.model.Usuario;
import uniandes.edu.co.app.repository.UsuarioRepository;

@Controller
public class loginController {

    private final UsuarioRepository usuarioRepo;

    public loginController(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(Model model, @RequestParam String username, @RequestParam String password) {
        // Check the username and password against the Oracle database
        // Assuming UsuarioRepo.loginUsuario returns a Collection of matching users
        Collection<Usuario> matchingUsers = usuarioRepo.loginUsuario(username, password);

        if (!matchingUsers.isEmpty()) {
            for (Usuario user : matchingUsers) {
                System.out.println("User ID: " + user.getId());
                if (user.getTipoUsuario().getTipo().equals("Cliente")) {
                    return "indexCliente";
                }
                if (user.getTipoUsuario().getTipo().equals("Recepcionista")) {
                    return "indexRecepcionista";
                }
                if (user.getTipoUsuario().getTipo().equals("Empleado")) {
                    return "indexEmpleado";
                }
                if (user.getTipoUsuario().getTipo().equals("Administrador")) {
                    return "indexAdmin";
                }
                if (user.getTipoUsuario().getTipo().equals("Gerente")) {
                    return "indexGerente";
                }
                if (user.getTipoUsuario().getTipo().equals("Gerente HotelAndes")) {
                    return "indexGerenteHA";
                }
            }
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }

        return "login";
    }
}

