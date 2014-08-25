/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Ventas;
import com.losalpes.servicios.ServicioReporteVentasMock;
import java.text.SimpleDateFormat;
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
     ServicioReporteVentasMock sreporte;
     List<Ventas> listaVentas;
     String filtro;
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
     return sreporte.agregarVenta(venta);;
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
    
}
