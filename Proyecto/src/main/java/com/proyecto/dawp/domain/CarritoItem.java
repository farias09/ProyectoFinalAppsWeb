
package com.proyecto.dawp.domain;


public class CarritoItem {
    
    private Articulo articulo;
    private int cantidad;
    
     public CarritoItem(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
    }
}
