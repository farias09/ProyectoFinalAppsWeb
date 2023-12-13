package com.proyecto.dawp.service;

import com.proyecto.dawp.domain.Cliente;
import java.util.List;

/**
 *
 * @author ferva
 */
public interface ClienteService {
    
    // Se obtiene un listado de clientes en un List
    public List<Cliente> getClientes();

    // Se obtiene un Cliente, a partir del id de un cliente
    public Cliente getCliente(Cliente cliente);

    // Se obtiene un Cliente, a partir del username de un cliente
    public Cliente getClientePorUsername(String username);

    // Se obtiene un Cliente, a partir del username y el password de un cliente
    public Cliente getClientePorUsernameYPassword(String username, String password);

    // Se inserta un nuevo cliente si el id del cliente esta vacío
    // Se actualiza un cliente si el id del cliente NO esta vacío
    public void save(Cliente cliente, boolean crearRolUser);

    // Se elimina el cliente que tiene el id pasado por parámetro
    public void delete(Cliente cliente);
    
}
