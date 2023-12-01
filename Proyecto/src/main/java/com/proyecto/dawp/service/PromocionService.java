package com.proyecto.dawp.service;

import com.proyecto.dawp.domain.Promocion;
import java.util.List;

/**
 *
 * @author ferva
 */

public interface PromocionService {
    
    // Se obtiene un listado de promocions en un List
    public List<Promocion> getPromociones(boolean activos);
    
   // Se obtiene un Promocion, a partir del id de un promocion
    public Promocion getPromocion(Promocion promocion);
    
    // Se inserta un nuevo promocion si el id del promocion esta vacío
    // Se actualiza un promocion si el id del promocion NO esta vacío
    public void save(Promocion promocion);
    
    // Se elimina el promocion que tiene el id pasado por parámetro
    public void delete(Promocion promocion);
    
}
