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
@Table(name = "productos")//TABLA DE PRUEBA
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;//esta linea funciona como auto increment para la tabla

    @Id //tabla productos tiene un identificador que va a ser el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// los valores generados que tipo de estrategia utilizan, identico = sea igual en BD y en la clase
    @Column(name = "id_producto")//identifica cual es el numbre en la base de datos
    private long idProducto;
    private String nombre;
    private String descripcion;
    private String codigo;
    private double precio;
    private int cantidad;
    private int promocion;
    private boolean activo;

    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    // Otros campos...
    @Column(name = "ruta_imagen")
    private String rutaImagen;

// Getter para rutaImagen
    public String getRutaImagen() {
        return this.rutaImagen;
    }

}
