/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dawp.service;

import com.proyecto.dawp.domain.Articulo;
import java.util.List;

public interface ArticuloService {
     // Obtener un listado de articuloes
    public List<Articulo> getArticulos();

    // Obtener un Articulo por ID
    public Articulo getArticulo(long idArticulo);

    // Guardar o actualizar un articulo
    public void save(Articulo articulo);

    // Eliminar un articulo por ID
    public void delete(long id);
    
    List<Articulo> obtenerArticulosPorCategoria(String producto);

}
