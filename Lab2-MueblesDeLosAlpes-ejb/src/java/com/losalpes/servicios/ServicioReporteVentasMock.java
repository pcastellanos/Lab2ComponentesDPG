/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Ventas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author xDEAMx
 */
public class ServicioReporteVentasMock {
    private List<Ventas> listadoVentas;

    public ServicioReporteVentasMock() {
        this.listadoVentas = new ArrayList<Ventas>();
        Ventas venta1= new Ventas();
        ServicioClientesMock scliente = new ServicioClientesMock();
        ServicioCatalogoMock scatalogo = new ServicioCatalogoMock();
        
        Cliente client = scliente.obtenerPorDocumento("1039456789");
        venta1.setCliente(client);
        venta1.setFechaDeCompra(new Date());
        List<MuebleVenta> lmuebleventa = new ArrayList<MuebleVenta>();
        MuebleVenta m1= new MuebleVenta(scatalogo.buscarMueble("RF1"), 3);
        MuebleVenta m2= new MuebleVenta(scatalogo.buscarMueble("RF2"), 4);
        lmuebleventa.add(m1);
        lmuebleventa.add(m2);
        venta1.setMueblesVenta(lmuebleventa);
        venta1.setTotal(this.obtenerValorTotal(venta1));
        this.listadoVentas.add(venta1);
    }
    
    public Double obtenerValorTotal(Ventas venta){
        Double total = 0.0;
        for(int i = 0; i < venta.getMueblesVenta().size() ; i++){
          total = total + (venta.getMueblesVenta().get(i).getCantidad() * venta.getMueblesVenta().get(i).getMueble().getPrecio());
        }
        
        return total;    
    }
    
    public List<Ventas> obtenerVentas(){
    return this.listadoVentas;
    }
    
    
}
