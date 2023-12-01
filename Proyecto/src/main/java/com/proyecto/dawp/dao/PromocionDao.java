package com.proyecto.dawp.dao;

import com.proyecto.dawp.domain.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ferva
 */
public interface PromocionDao extends JpaRepository <Promocion, Long> {
    
}
