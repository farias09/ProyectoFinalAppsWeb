package com.proyecto.dawp.controller;

import com.proyecto.dawp.domain.Promocion;
import com.proyecto.dawp.domain.Promocion;
import com.proyecto.dawp.service.PromocionService;
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
@RequestMapping("/promocion")
public class PromocionControlador {
    
    @Autowired
    private PromocionService promocionService;

    @GetMapping("/promocionesPage")
    public String inicio(Model model) {
        var promocion = promocionService.getPromociones(false);
        model.addAttribute("promociones", promocion);
        model.addAttribute("totalPromociones", promocion.size());
        return "/promocion/promocionesPage";
    }
    
    @GetMapping("/nuevo")
    public String promocionNuevo(Promocion promocion) {
        return "/promocion/modifica";
    }

    
}
