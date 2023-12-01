package com.proyecto.dawp.controller;

import com.proyecto.dawp.domain.Producto;
import com.proyecto.dawp.domain.Producto;
import com.proyecto.dawp.service.ProductoService;
//import com.proyecto.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ferva
 */

@Controller
@Slf4j
@RequestMapping("/producto")
public class ProductoControlador {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productsPage")
    public String inicio(Model model) {
        var producto = productoService.getProductos(false);
        model.addAttribute("productos", producto);
        model.addAttribute("totalProductos", producto.size());
        return "/producto/productsPage";
    }
    
    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }
}
