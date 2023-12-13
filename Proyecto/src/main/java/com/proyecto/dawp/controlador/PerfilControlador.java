package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Cliente;
import com.proyecto.dawp.service.ClienteService;
import com.proyecto.dawp.service.FirebaseStorageService;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/perfil")
public class PerfilControlador {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/perfilPage")
    public String inicio(Model model, Principal principal) {
        // Obtener el nombre de usuario del usuario logeado
        String username = principal.getName();

        // Obtener el cliente por nombre de usuario
        Cliente cliente = clienteService.getClientePorUsername(username);

        // Agregar el cliente al modelo
        model.addAttribute("cliente", cliente);

        return "/perfil/perfilPage";
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes", clientes.size());
        return "/perfil/listado";
    }

    @GetMapping("/modificar")
    public String clienteModificar(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Cliente cliente = clienteService.getClientePorUsername(userDetails.getUsername());
        model.addAttribute("cliente", cliente);
        return "/perfil/modifica";
    }

    @PostMapping("/modificar")
    public String modificarCredenciales(@ModelAttribute("cliente") Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile, Principal principal) {
        // Obtener el nombre de usuario del usuario logeado
        String username = principal.getName();

        // Obtener el cliente por nombre de usuario
        Cliente clienteActual = clienteService.getClientePorUsername(username);

        // Actualizar la información del cliente
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setCedula(cliente.getCedula());
        clienteActual.setCorreo(cliente.getCorreo());
        clienteActual.setNumeroTelefono(cliente.getNumeroTelefono());
        clienteActual.setDireccion(cliente.getDireccion());

        if (!imagenFile.isEmpty()) {
            clienteActual.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "cliente",
                            clienteActual.getIdCliente()));
        }

        clienteService.save(clienteActual, false);

        return "redirect:/perfil/perfilPage";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(@ModelAttribute("cliente") Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            cliente.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "cliente",
                            cliente.getIdCliente()));
        }
        clienteService.save(cliente, true);
        return "perfil/guardar";
    }

    @GetMapping("/")
    public String perfil(Model model, Authentication authentication) {

        // Obtener usuario autenticado
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Cliente cliente = clienteService.getClientePorUsername(userDetails.getUsername());

        model.addAttribute("cliente", cliente);

        return "perfil/paneles";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/perfil/listado";
    }

    @PostMapping("/actualizar-imagen")
    public String actualizarImagen(@RequestParam("imagenFile") MultipartFile imagenFile, Principal principal) {
        // Obtener el nombre de usuario del usuario logeado
        String username = principal.getName();

        // Obtener el cliente por nombre de usuario
        Cliente cliente = clienteService.getClientePorUsername(username);

        // Actualizar la imagen de perfil
        if (!imagenFile.isEmpty()) {
            cliente.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "cliente",
                            cliente.getIdCliente()));
            clienteService.save(cliente, false);
        }
        return "redirect:/perfil/perfilPage";
    }
    
}
