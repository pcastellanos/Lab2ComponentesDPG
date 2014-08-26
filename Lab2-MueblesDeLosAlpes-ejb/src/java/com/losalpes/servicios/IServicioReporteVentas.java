/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Ventas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulacastellanos
 */
public interface IServicioReporteVentas {
    
    public Double obtenerValorTotal(Ventas venta);
    /**
     * Recibe parametro para filtrar por fecha
     * @param filtro
     * @return 
     */
    public List<Ventas> obtenerVentas(String filtro);
    
    /**
     * Metodo para agregar una nueva venta que realizo un cliente
     * @param venta
     * @return boolean
     */
    public Boolean agregarVenta(Ventas venta);
    
    /**
     * Metodo encargado de validar la fecha ingresada para validar Reporte
     * @param filtro
     * @return 
     */
    public List<Ventas> filtrarPorFecha(String filtro);
    
    public String obtenerProductoConMayorVentas();
    
    /**
     * Obtiene el reporte de un cliente
     * @param documento
     * @return 
     */
    public List<Ventas> obtenerReporteCliente(String documento);
    
    
}
