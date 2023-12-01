package com.proyecto.dawp.dao;

import com.proyecto.dawp.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ferva
 */
public interface ProductoDao extends JpaRepository <Producto, Long> {
    
}
