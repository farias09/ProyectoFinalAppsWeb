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
@Table(name="promociones")//TABLA DE PRUEBA
public class Promocion implements Serializable{
    
    private static final long serialVersionUID = 1L;//esta linea funciona como auto increment para la tabla
    
    @Id //tabla promociones tiene un identificador que va a ser el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// los valores generados que tipo de estrategia utilizan, identico = sea igual en BD y en la clase
    @Column(name="id_promocion")//identifica cual es el numbre en la base de datos
    private long idPromocion;
    private String descripcion;
    private double precio;
    private int cantidad;
    private boolean activo;

    public Promocion() {
    }

    public Promocion(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
}

//test
