package com.proyecto.dawp.dao;

import com.proyecto.dawp.domain.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloDao extends JpaRepository <Articulo, Long> {
    
    List<Articulo> findByDescripcion(String descripcion);
}
