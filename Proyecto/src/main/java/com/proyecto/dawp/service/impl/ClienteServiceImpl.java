package com.proyecto.dawp.service.impl;

import com.proyecto.dawp.dao.RolDao;
import com.proyecto.dawp.dao.ClienteDao;
import com.proyecto.dawp.domain.Rol;
import com.proyecto.dawp.domain.Cliente;
import com.proyecto.dawp.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author ferva
 */

@Service
public class ClienteServiceImpl implements ClienteService {
    
       @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsername(String username) {
        return clienteDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsernameYPassword(String username, String password) {
        return clienteDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClientePorUsernameOCorreo(String username, String correo) {
        return clienteDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeClientePorUsernameOCorreo(String username, String correo) {
        return clienteDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Cliente cliente, boolean crearRolUser) {
        cliente=clienteDao.save(cliente);
        if (crearRolUser) {  //Si se está creando el cliente, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_USER");
            rol.setIdCliente(cliente.getIdCliente());
            rolDao.save(rol);
        }
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
}
