package com.proyecto.dawp.controlador;

import com.proyecto.dawp.domain.Perfil;
import com.proyecto.dawp.domain.Perfil;
import com.proyecto.dawp.service.PerfilService;
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
@RequestMapping("/perfil")
public class PerfilControlador {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/usuarioPanel")
    public String inicio(Model model) {
        var perfiles = perfilService.getPerfiles();
        model.addAttribute("perfiles", perfiles);
        model.addAttribute("totalPerfiles", perfiles.size());
        return "/perfil/usuarioPanel";
    }

    @GetMapping("/nuevo")
    public String perfilNuevo(Perfil perfil) {
        return "/perfil/modifica";
    }
}
