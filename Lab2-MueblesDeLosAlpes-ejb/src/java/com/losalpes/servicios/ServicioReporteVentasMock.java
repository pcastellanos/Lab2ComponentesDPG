/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Ventas;
import java.text.SimpleDateFormat;
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
    /**
     * Recibe parametro para filtrar por fecha
     * @param filtro
     * @return 
     */
    public List<Ventas> obtenerVentas(String filtro){
    List<Ventas> listaVentasTmp = filtro.equals("") ? this.listadoVentas : filtrarPorFecha(filtro);
    return listaVentasTmp;
    }
    
    /**
     * Metodo para agregar una nueva venta que realizo un cliente
     * @param venta
     * @return boolean
     */
    public Boolean agregarVenta(Ventas venta){
    this.listadoVentas.add(venta);
    return true;
    }
    
    /**
     * Metodo encargado de validar la fecha ingresada para validar Reporte
     * @param filtro
     * @return 
     */
    public List<Ventas> filtrarPorFecha(String filtro){
         List<Ventas> listaVentasTmp = new ArrayList<Ventas>();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      for(int i=0;i<this.listadoVentas.size();i++){
           String fecha = sdf.format(this.listadoVentas.get(i).getFechaDeCompra());
           System.out.println(i+" - "+fecha);
           if(fecha.equals(filtro)){
              listaVentasTmp.add(this.listadoVentas.get(i));
           }
        }
      return listaVentasTmp;
    }
    
    public String obtenerProductoConMayorVentas(){
        List<String[]> listaProductos = new ArrayList<String[]>();
        for(int i=0;i<this.listadoVentas.size();i++){
            Ventas ventatmp = this.listadoVentas.get(i);
            for(int j=0; i<ventatmp.getMueblesVenta().size();i++){
                MuebleVenta muebleTmp =ventatmp.getMueblesVenta().get(j);
                muebleTmp.getMueble().getNombre();
            }
        }
        
        
    return "";
    }
    
    
}
