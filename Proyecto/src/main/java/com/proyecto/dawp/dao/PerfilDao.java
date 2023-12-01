package com.proyecto.dawp.dao;

import com.proyecto.dawp.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ferva
 */
public interface PerfilDao extends JpaRepository <Perfil, Long> {
    
}
