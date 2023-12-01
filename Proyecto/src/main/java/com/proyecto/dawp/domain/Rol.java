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
@Table(name = "rol")
public class Rol implements Serializable{ //la serializacion funciona para almacenar varios datos en el disco
    
    private static final long serialVersionUID = 1L;

    @Id //tabla rol tiene un identificador que va a ser el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// los valores generados que tipo de estrategia utilizan, identico = sea igual en BD y en la clase
    @Column(name = "id_rol")
    private Long idRol;
    private String nombre;

    @Column(name = "id_cliente")//identifica cual es el numbre en la base de datos
    private Long idCliente;

}

