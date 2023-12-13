package com.proyecto.dawp.service;

import com.proyecto.dawp.domain.Cliente;

/**
 *
 * @author ferva
 */
public interface RegistroService {
    
    void procesarRegistro(Cliente cliente, String confirmPassword, boolean crearRolUser);
    
}
