/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;
import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Ventas;
import com.losalpes.servicios.IServicioReporteVentas;
import com.losalpes.servicios.ServicioReporteVentasMock;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author xDEAMx
 */
@ManagedBean(eager = true , name="reporteComprasBean")
@ApplicationScoped
public class ReporteComprasBean {
     IServicioReporteVentas sreporte;
     List<Ventas> listaVentas;
     String filtro;
     List<Ventas> ventasCliente;
     String nombreClienteDetalle;
     Double totalVentasDetalle;
     String productoMasVendido;
     String paginaOrigen;
     String origenReporte;
     String origenReporteCliente;
     
    /**
     * Creates a new instance of ReporteComprasBean
     */
    public ReporteComprasBean() {
       
        System.out.println("ReportebeanConstruido constructed");
        this.setFiltro("");
        if(this.listaVentas==null){
          this.listaVentas = new ArrayList<Ventas>();
          sreporte = new ServicioReporteVentasMock();
          this.setListaVentas(sreporte.obtenerVentas(""));
          System.out.print("inicia con "+this.getListaVentas().size());
        }
        
        
    }
    
    public String volverAdmin(){
     return "volver";
    }
    
    public boolean agregarVenta(Ventas venta){
     return sreporte.agregarVenta(venta);
    }
    
    public String filtrarVentas(){
    this.setListaVentas(sreporte.obtenerVentas(this.getFiltro()));
    return "verReporte";
    }

    public List<Ventas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }
   

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    public String verDetalleVenta(String numeroDocumento,String origen){
        System.out.println(numeroDocumento+" "+origen);
     this.setPaginaOrigen(origen);
     ventasCliente = sreporte.obtenerReporteCliente(numeroDocumento);
     nombreClienteDetalle = "";
     totalVentasDetalle = 0.0;
     if(ventasCliente.size()>0)
     {
         nombreClienteDetalle = ventasCliente.get(0).getCliente().getNombre();
         totalVentasDetalle = calcularTotal(ventasCliente);
     }
     return "detalleComprasClienteView";
    }
    /**
     * Obtiene el detalle del cliente seleccionado
     * @return 
     */
    //Cambiar
    public List<Ventas> getResumenCompras(){
       return ventasCliente;
    }

    private Double calcularTotal(List<Ventas> ventasCliente) {
        Double total=0.0;
        for(Ventas venta: ventasCliente){
            total += venta.getTotal();
        }
        return  total;
    }

    public String getNombreClienteDetalle() {
        return nombreClienteDetalle;
    }

    public void setNombreClienteDetalle(String nombreClienteDetalle) {
        this.nombreClienteDetalle = nombreClienteDetalle;
    }

    public Double getTotalVentasDetalle() {
        return totalVentasDetalle;
    }

    public void setTotalVentasDetalle(Double totalVentasDetalle) {
        this.totalVentasDetalle = totalVentasDetalle;
    }
    
    
    public String getProductoMasVendido(){
        return sreporte.obtenerProductoConMayorVentas();
    }

    public String getPaginaOrigen() {
        return paginaOrigen;
    }

    public void setPaginaOrigen(String paginaOrigen) {
        this.paginaOrigen = paginaOrigen;
    }

    public String getOrigenReporte() {
        origenReporte = "reporte";
        return origenReporte;
    }

    public String getOrigenReporteCliente() {
        origenReporteCliente = "reporteCliente";
        return origenReporteCliente;
    }
    
    
    
    
}
