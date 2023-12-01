package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Cliente;
import com.proyecto.dawp.service.ClienteService;
import com.proyecto.dawp.service.FirebaseStorageService;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/perfil")
public class PerfilControlador {

    @GetMapping("/perfilPage")
    public String inicio(Model model, Principal principal) {
        // Obtener el nombre de usuario del usuario logeado
        String username = principal.getName();

        // Obtener el cliente (usuario) por nombre de usuario
        Cliente cliente = clienteService.getClientePorUsername(username);

        // Agregar el cliente al modelo
        model.addAttribute("cliente", cliente);

        return "/perfil/perfilPage";
    }

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "/perfil/listado";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/perfil/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            clienteService.save(cliente,false);
            cliente.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "cliente",
                            cliente.getIdCliente()));
        }
        clienteService.save(cliente,true);
        return "redirect:/perfil/listado";
    }
    
    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/perfil/listado";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/perfil/modifica";
    }
}
