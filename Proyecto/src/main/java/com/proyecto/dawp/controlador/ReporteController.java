/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dawp.controlador;

import com.proyecto.dawp.service.ReporteService;
import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author ferva
 */
@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @GetMapping("/paneles")
    public String principal(Model model) {
        return "/reportes/paneles";
    }

    @GetMapping("/clientes")
    public ResponseEntity<Resource> clientes(@RequestParam String tipo) throws IOException{
        return reporteService.generaReporte("clientes", null, tipo);
    }
}
