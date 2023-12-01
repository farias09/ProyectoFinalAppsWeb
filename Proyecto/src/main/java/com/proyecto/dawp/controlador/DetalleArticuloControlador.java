
package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Articulo;
import com.proyecto.dawp.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author faria
 */

@Controller
@Slf4j
@RequestMapping("/articulos")
public class DetalleArticuloControlador {
    
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("detalle/{idArticulo}")
    public String verDetalleArticulo(@PathVariable Long idArticulo, Model model) {
        Articulo articulo = articuloService.getArticulo(idArticulo);
        model.addAttribute("articulo", articulo);
        return "/articulos/detalleArticulo";
    }
}
