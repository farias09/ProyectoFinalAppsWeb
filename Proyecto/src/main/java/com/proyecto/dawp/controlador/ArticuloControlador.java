
package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Articulo;
import com.proyecto.dawp.service.ArticuloService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/articulos")
public class ArticuloControlador {
    
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/dulces")
    public String mostrarArticulosDulces(Model model) {
        List<Articulo> articulosDulces = articuloService.obtenerArticulosPorCategoria("Dulces");
        model.addAttribute("articulos", articulosDulces);
        return "/articulos/dulces";
        
    }
    @GetMapping("/bebidas")
    public String mostrarArticulosBebidas(Model model) {
        List<Articulo> articulosBebidas = articuloService.obtenerArticulosPorCategoria("Bebidas");
        model.addAttribute("articulos", articulosBebidas);
        return "/articulos/bebidas";
    }
    
    @GetMapping("/cereales")
    public String mostrarArticulosCereales(Model model) {
        List<Articulo> articulosCereales = articuloService.obtenerArticulosPorCategoria("Cereales");
        model.addAttribute("articulos", articulosCereales);
        return "/articulos/cereales";
    }
    
    @GetMapping("/frutas")
    public String mostrarArticulosFrutas(Model model) {
        List<Articulo> articulosFrutas = articuloService.obtenerArticulosPorCategoria("Frutas");
        model.addAttribute("articulos", articulosFrutas);
        return "/articulos/frutas";
    }
}
