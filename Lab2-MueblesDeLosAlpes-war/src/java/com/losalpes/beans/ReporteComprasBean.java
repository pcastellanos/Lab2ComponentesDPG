/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Ventas;
import com.losalpes.servicios.ServicioReporteVentasMock;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author xDEAMx
 */
@ManagedBean
@ApplicationScoped
public class ReporteComprasBean {
     List<Ventas> listaVentas;
    /**
     * Creates a new instance of ReporteComprasBean
     */
    public ReporteComprasBean() {
        
        if(this.listaVentas==null){
          this.listaVentas = new ArrayList<Ventas>();
            ServicioReporteVentasMock sreporte = new ServicioReporteVentasMock();
            this.listaVentas= sreporte.obtenerVentas();
        }
    }
    
    public String volverAdmin(){
     return "volver";
    }

    public List<Ventas> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    
}
