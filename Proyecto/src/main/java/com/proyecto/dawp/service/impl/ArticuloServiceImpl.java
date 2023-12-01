
package com.proyecto.dawp.service.impl;
import com.proyecto.dawp.dao.ArticuloDao;
import com.proyecto.dawp.dao.ArticuloDao;
import com.proyecto.dawp.domain.Articulo;
import com.proyecto.dawp.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author faria
 */

@Service
public class ArticuloServiceImpl implements ArticuloService {
 

    @Autowired
    public ArticuloServiceImpl(ArticuloDao articuloDao) {
        this.articuloDao = articuloDao;
    }
    
    @Autowired
    private ArticuloDao articuloDao;
    

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos() {
        return articuloDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(long idArticulo) {
        return articuloDao.findById(idArticulo).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(long id) {
        articuloDao.deleteById(id);
    }

    @Override
    public List<Articulo> obtenerArticulosPorCategoria(String descripcion) {
        return articuloDao.findByDescripcion(descripcion);
    }
}
