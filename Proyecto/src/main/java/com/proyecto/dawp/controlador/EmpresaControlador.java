package com.proyecto.dawp.controlador;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ferva
 */
@Controller
@Slf4j
@RequestMapping("/empresa")
public class EmpresaControlador {

    @GetMapping("/empresaPage")
    public String inicio() {
        return "/empresa/empresaPage";
    }

}
