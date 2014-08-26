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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author xDEAMx
 */
public class ServicioReporteVentasMock implements IServicioReporteVentas {
    private List<Ventas> listadoVentas;

    /**
     * Constructor del servuicio Reporte ventas
     */
    public ServicioReporteVentasMock() {
        this.listadoVentas = new ArrayList<Ventas>();
        LinkedList<String> referencias = new LinkedList<String>();
        referencias.add("RF1");
        referencias.add("RF2");
        agregarCompra("1039456789", referencias, new Date());
        
        referencias = new LinkedList<String>();
        referencias.add("RF1");
        referencias.add("RF7");
        referencias.add("RF4");
        referencias.add("RF3");
        referencias.add("RF2");
        agregarCompra("0980867854", referencias, new Date());
        
        referencias = new LinkedList<String>();
        referencias.add("RF7");
        referencias.add("RF4");
        agregarCompra("33464574734", referencias, new Date());
        
        referencias = new LinkedList<String>();
        referencias.add("RF7");
        referencias.add("RF4");
        referencias.add("RF2");
        referencias.add("RF8");
        referencias.add("RF6");
        agregarCompra("2342423432424", referencias, new Date());

        referencias = new LinkedList<String>();
        referencias.add("RF7");
        referencias.add("RF3");
        referencias.add("RF5");
        referencias.add("RF2");
        referencias.add("RF6");
        agregarCompra("33464574734", referencias, new Date());
                
    }
    /**
     * Se encarga de agregar una nueva venta     * 
     * @param documentoCliente
     * @param referencias
     * @param fecha 
     */
    private void agregarCompra(String documentoCliente, List<String> referencias, Date fecha ){
        ServicioClientesMock scliente = new ServicioClientesMock();
        ServicioCatalogoMock scatalogo = new ServicioCatalogoMock();
        Ventas venta= new Ventas();
        MuebleVenta muebleVendido;
        
        List<MuebleVenta> lmuebleventa = new ArrayList<MuebleVenta>();
        
        Cliente client = scliente.obtenerPorDocumento(documentoCliente);
        venta.setCliente(client);
        venta.setFechaDeCompra(fecha);
        for(String referencia : referencias){
        muebleVendido = new MuebleVenta(scatalogo.buscarMueble(referencia), (int)(Math.random()*10));
        lmuebleventa.add(muebleVendido);
        }
        venta.setMueblesVenta(lmuebleventa);
        venta.setTotal(this.obtenerValorTotal(venta));
        this.listadoVentas.add(venta);
    }
    
    /**
     * Obtener el valor total de una venta conforme sus productos
     * @param venta
     * @return 
     */
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
           if(fecha.equals(filtro)){
              listaVentasTmp.add(this.listadoVentas.get(i));
           }
        }
      return listaVentasTmp;
    }
    /**
     * Se encarga de validartodos los productos de la venta y selecciona el producto más vendido
     * @return 
     */
    public String obtenerProductoConMayorVentas(){
        List<String[]> listaProductos = new ArrayList<String[]>();
        for(int i=0;i<this.listadoVentas.size();i++){
            Ventas ventatmp = this.listadoVentas.get(i);
            for(int j=0; i<ventatmp.getMueblesVenta().size();i++){
                MuebleVenta muebleTmp =ventatmp.getMueblesVenta().get(j);
                if(listaProductos.size()>0){
                  boolean nuevoProducto = true;
                  for(int z=0;z<listaProductos.size();z++){
                     if(listaProductos.get(z)[2].equals(muebleTmp.getMueble().getReferencia())){
                         nuevoProducto = false;
                         
                         listaProductos.get(z)[1]=String.valueOf(Integer.parseInt(listaProductos.get(z)[1])
                                                                 +muebleTmp.getCantidad());
                     }
                  }
                  if(nuevoProducto){
                    String[] obj = new String[3];
                    obj[0] = muebleTmp.getMueble().getNombre();
                    obj[1] = String.valueOf(muebleTmp.getMueble().getCantidad());
                    obj[2] = muebleTmp.getMueble().getReferencia();
                    listaProductos.add(obj);
                  }
                }else{
                    String[] obj = new String[3];
                    obj[0] = muebleTmp.getMueble().getNombre();
                    obj[1] = String.valueOf(muebleTmp.getCantidad());
                    obj[2] = muebleTmp.getMueble().getReferencia();
                    listaProductos.add(obj);
                }
            }
        }
        String producto ="--";
        int cantidadMayor = 0;
        for(int i=0;i<listaProductos.size();i++){
           if(Integer.parseInt(listaProductos.get(i)[1])>cantidadMayor){
              producto=listaProductos.get(i)[2] +" - "+listaProductos.get(i)[0]+" Total:"+listaProductos.get(i)[1];
           }
        } 
    return producto;
    }
    
    /**
     * Obtiene el reporte de un cliente
     * @param documento
     * @return 
     */
    public List<Ventas> obtenerReporteCliente(String documento){
        List<Ventas> ventas = new LinkedList<Ventas>();
        int longitud = listadoVentas.size();
        for(int i=0; i< longitud; i ++){
            if(listadoVentas.get(i).getCliente().getNumeroDocumento().equals(documento)){
                 ventas.add(listadoVentas.get(i));
            }
        }
        return ventas;
    }
    
    
}
