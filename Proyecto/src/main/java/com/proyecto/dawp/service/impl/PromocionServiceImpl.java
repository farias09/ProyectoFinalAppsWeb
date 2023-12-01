package com.proyecto.dawp.service.impl;

import com.proyecto.dawp.dao.PromocionDao;
import com.proyecto.dawp.domain.Promocion;
import com.proyecto.dawp.service.PromocionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ferva
 */

@Service
public class PromocionServiceImpl implements PromocionService {
    
    @Autowired
    private PromocionDao promocionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Promocion> getPromociones(boolean activos) {
        var lista = promocionDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Promocion getPromocion(Promocion promocion) {
        return promocionDao.findById(promocion.getIdPromocion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Promocion promocion) {
        promocionDao.save(promocion);
    }

    @Override
    @Transactional
    public void delete(Promocion promocion) {
        promocionDao.delete(promocion);
    }
    
}
