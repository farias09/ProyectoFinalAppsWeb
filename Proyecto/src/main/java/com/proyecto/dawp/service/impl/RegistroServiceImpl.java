package com.proyecto.dawp.service.impl;

import com.proyecto.dawp.domain.Cliente;
import com.proyecto.dawp.domain.Rol;
import com.proyecto.dawp.service.ClienteService;
import com.proyecto.dawp.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author ferva
 */
@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private ClienteService clienteService;

    @Override
    public void procesarRegistro(Cliente cliente, String confirmPassword, boolean crearRolUser) {
        // Validar que las contraseñas coincidan
        if (!cliente.getPassword().equals(confirmPassword)) {
            // Puedes lanzar una excepción o manejar el error de alguna otra manera
            throw new RuntimeException("Las contraseñas no coinciden");
        }

        // Se encripta la contraseña
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(cliente.getPassword());
        cliente.setPassword(hashedPassword);

        // Establecer el rol por defecto "USER"
        Rol rol = new Rol();
        rol.setNombre("ROLE_USER");
        cliente.setRoles(Collections.singletonList(rol));

        // Agregar la URL de la imagen al perfil del cliente
        cliente.setRutaImagen("https://i.pinimg.com/280x280_RS/42/03/a5/4203a57a78f6f1b1cc8ce5750f614656.jpg");

        // Marcar al usuario como activo
        cliente.setActivo(true);

        // Guardar el cliente
        clienteService.save(cliente, crearRolUser);
    }
}
