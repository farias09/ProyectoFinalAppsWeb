package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Cliente;
import com.proyecto.dawp.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/nuevo")
    public String registroUsuario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro/nuevo";
    }

    @PostMapping("/nuevo")
    public String procesarRegistro(@ModelAttribute("cliente") Cliente cliente,
            @RequestParam("confirmPassword") String confirmPassword,
            Model model) {
        try {
            // Llamar al servicio para procesar el registro
            registroService.procesarRegistro(cliente, confirmPassword, true);

            // Redirigir a la ruta del perfil después de un registro exitoso
            return "redirect:/perfil";
        } catch (RuntimeException e) {
            // Manejar el error y devolver a la página de registro con un mensaje de error
            model.addAttribute("error", e.getMessage());
            return "/registro/nuevo";
        }
    }
}
