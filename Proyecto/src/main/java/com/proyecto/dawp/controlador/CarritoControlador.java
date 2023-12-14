
package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Articulo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/carrito")
public class CarritoControlador {
    
   @GetMapping("/carrito")
    public String verCarrito() {
        return "/carrito/carrito";
    }
}
