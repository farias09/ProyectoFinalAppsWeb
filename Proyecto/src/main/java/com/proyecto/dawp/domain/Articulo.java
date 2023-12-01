package com.proyecto.dawp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Data
@Entity
@Table(name = "articulo")//TABLA DE CLIENTES
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;//esta linea funciona como auto increment para la tabla

    @Id //tabla clientes tiene un identificador que va a ser el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// los valores generados que tipo de estrategy utilizan, identico = sea igual en BD y en la clase
    @Column(name = "id_articulo")//identifica cual es el numbre en la base de datos
    private long idArticulo;
    private String descripcion;
    private String codigo;
    private double precio;
    private int cantidad;
    private int promocion;
    private boolean activo;

    public Articulo() {
    }

    public Articulo(String descripcion) {
        this.descripcion = descripcion;
    }
    
   
    
}