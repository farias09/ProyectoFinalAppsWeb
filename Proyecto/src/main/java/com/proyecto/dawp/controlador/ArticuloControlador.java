
package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Articulo;
import com.proyecto.dawp.service.ArticuloService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/carnes")
    public String mostrarArticulosCarnes(Model model) {
        List<Articulo> articulosCarnes = articuloService.obtenerArticulosPorCategoria("Carnes");
        model.addAttribute("articulos", articulosCarnes);
        return "/articulos/carnes";
    }
    
    @GetMapping("/vegetales")
    public String mostrarArticulosVegetales(Model model) {
        List<Articulo> articulosVegetales = articuloService.obtenerArticulosPorCategoria("Vegetales");
        model.addAttribute("articulos", articulosVegetales);
        return "/articulos/vegetales";
    }
    
    @GetMapping("/chocolates")
    public String mostrarArticulosChocolates(Model model) {
        List<Articulo> articulosChocolates = articuloService.obtenerArticulosPorCategoria("Chocolates");
        model.addAttribute("articulos", articulosChocolates);
        return "/articulos/chocolates";
    }
    
    @GetMapping("/embutidos")
    public String mostrarArticulosEmbutidos(Model model) {
        List<Articulo> articulosEmbutidos = articuloService.obtenerArticulosPorCategoria("Embutidos");
        model.addAttribute("articulos", articulosEmbutidos);
        return "/articulos/embutidos";
    }
    
    @GetMapping("/congelados")
    public String mostrarArticulosCongelados(Model model) {
        List<Articulo> articulosCongelados = articuloService.obtenerArticulosPorCategoria("Congelados");
        model.addAttribute("articulos", articulosCongelados);
        return "/articulos/congelados";
    }
    
    @GetMapping("/panaderia")
    public String mostrarArticulosPanaderia(Model model) {
        List<Articulo> articulosPanaderia = articuloService.obtenerArticulosPorCategoria("Panaderia");
        model.addAttribute("articulos", articulosPanaderia);
        return "/articulos/panaderia";
    }

    @GetMapping("/lacteos")
    public String mostrarArticulosLacteos(Model model) {
        List<Articulo> articulosLacteos = articuloService.obtenerArticulosPorCategoria("Lacteos");
        model.addAttribute("articulos", articulosLacteos);
        return "/articulos/lacteos";
    }

    @GetMapping("/licores")
    public String mostrarArticulosLicores(Model model) {
        List<Articulo> articulosLicores = articuloService.obtenerArticulosPorCategoria("Licores");
        model.addAttribute("articulos", articulosLicores);
        return "/articulos/licores";
    }
}
