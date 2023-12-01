package com.proyecto.dawp.dao;

import com.proyecto.dawp.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ferva
 */
public interface ClienteDao extends JpaRepository<Cliente, Long> {

    Cliente findByUsername(String username);

    Cliente findByUsernameAndPassword(String username, String password);

    Cliente findByUsernameOrCorreo(String username, String correo);
   
    boolean existsByUsernameOrCorreo(String username, String correo);
}

