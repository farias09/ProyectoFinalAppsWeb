package com.proyecto.dawp.service;

import com.proyecto.dawp.domain.Perfil;
import java.util.List;

/**
 *
 * @author ferva
 */
public interface PerfilService {

    // Obtener un listado de perfiles
    public List<Perfil> getPerfiles();

    // Obtener un Perfil por ID
    public Perfil getPerfil(long id);

    // Guardar o actualizar un perfil
    public void save(Perfil perfil);

    // Eliminar un perfil por ID
    public void delete(long id);
}
