package com.proyecto.dawp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author ferva
 */
@Data
@Entity
@Table(name = "clientes")//TABLA DE CLIENTES
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;//esta linea funciona como auto increment para la tabla

    @Id //tabla clientes tiene un identificador que va a ser el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// los valores generados que tipo de estrategy utilizan, identico = sea igual en BD y en la clase
    @Column(name = "id_cliente")//identifica cual es el numbre en la base de datos
    private long idCliente;
    private String nombre;
    private String correo;
    private int numeroTelefono;
    private String direccion;
    private int cedula;
    private String contraseña;

    public Perfil() {
    }

    public Perfil(String nombre) {
        this.nombre = nombre;
    }
}
