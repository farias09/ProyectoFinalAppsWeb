/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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

    // Se obtiene un Cliente, a partir del username y el password de un cliente
    public Cliente getClientePorUsernameOCorreo(String username, String correo);

    // Se valida si existe un Cliente considerando el username
    public boolean existeClientePorUsernameOCorreo(String username, String correo);

    // Se inserta un nuevo cliente si el id del cliente esta vacío
    // Se actualiza un cliente si el id del cliente NO esta vacío
    public void save(Cliente cliente, boolean crearRolUser);

    // Se elimina el cliente que tiene el id pasado por parámetro
    public void delete(Cliente cliente);
    
}
