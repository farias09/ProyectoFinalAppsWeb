package com.proyecto.dawp.service.impl;

import com.proyecto.dawp.dao.ClienteDao;
import com.proyecto.dawp.domain.Cliente;
import com.proyecto.dawp.domain.Rol;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.dawp.service.ClienteDetailsService;

@Service("userDetailsService")
public class ClienteDetailsServiceImpl implements ClienteDetailsService, UserDetailsService {

    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Se busca el cliente que tiene el username pasado por parámetro...
        Cliente cliente = clienteDao.findByUsername(username);

        //Se valida si se recuperó un cliente / sino lanza un error
        if (cliente == null) {
            throw new UsernameNotFoundException(username);
        }

        //Si estamos acá es porque si se recuperó un cliente...
        session.removeAttribute("clienteImagen");
        session.setAttribute("clienteImagen", cliente.getRutaImagen());

        //Se van a recuperar los roles del cliente y se crean los roles ya como seguridad de Spring
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : cliente.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        //Se retorna un User (de tipo UserDetails)
        return new User(cliente.getUsername(), cliente.getPassword(), roles);
    }
}
