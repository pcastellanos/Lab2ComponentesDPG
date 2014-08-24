/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

/**
 *
 * @author paulacastellanos
 */
public class MuebleVenta {
    private Mueble mueble;
    private int cantidad;

    /**
     * Constructor
     * @param mueble Mueble a vender
     * @param cantidad  cantidades requeridas
     */
    public MuebleVenta(Mueble mueble, int cantidad) {
        this.mueble = mueble;
        this.cantidad = cantidad;
    }
    
    /**
     * Obtiene el mueble a comprar
     * @return 
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * asigna el mueble a comprar
     * @param mueble 
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    /**
     * Cantidad a comprar
     * @return 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * cambia la cantidad a comprar
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
