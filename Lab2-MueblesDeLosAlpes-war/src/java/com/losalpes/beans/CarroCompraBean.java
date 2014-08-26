/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoMueble;
import com.losalpes.bos.Ventas;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.ServicioCatalogoMock;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulacastellanos
 */
@ManagedBean
@SessionScoped
public class CarroCompraBean {

    List<MuebleVenta> mueblesVenta;
    IServicioCatalogo catalogo;
    int idDetalle;
    private int cantidadDetalle;
    
    @ManagedProperty(value="#{reporteComprasBean}")
    private ReporteComprasBean reporteComprasBean;
    
    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;

    public LoginBean getLoginBean()
    {
    return loginBean;
    }

    public void setLoginBean(LoginBean loginBean)
    {
    this.loginBean = loginBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("ejecuta post construcción "+reporteComprasBean);
    }
    
    

    public void setReporteComprasBean(ReporteComprasBean reporteComprasBean) {
        this.reporteComprasBean = reporteComprasBean;
    }
    
    public ReporteComprasBean getReporteComprasBean() {
       return this.reporteComprasBean;
    }
    
    /**
     * Creates a new instance of CarroCompraBean
     */
    public CarroCompraBean() {
        catalogo = new ServicioCatalogoMock();
        mueblesVenta=new LinkedList<MuebleVenta>();
        List<Mueble> muebles = catalogo.darMuebles();
        for(Mueble mueble: muebles)
        {
            mueblesVenta.add(new MuebleVenta(mueble, 0));
        }
        idDetalle =-1;
    }
    
    /**
     * Listados de muebles a la venta
     * @return 
     */
    public List<MuebleVenta> getMuebles(){
        return mueblesVenta;      
    }
    
    /**
     * Agregar mueble al carro de compras
     * @param referencia
     * @param cantidad 
     */
    public String actualizarCantidadMuebleCarro(String referencia,int cantidad){
        String pagina ="";
        int posicion = getPosMueble(referencia, mueblesVenta);
        mueblesVenta.get(posicion).setCantidad(cantidad);
        if(idDetalle!=-1){
            idDetalle =-1;
            pagina ="comprasView";
        }
        return pagina;
    }
    
    public String act(String referencia){
         int cantidad = this.getCantidadDetalle();//mueblesVenta.get(idDetalle).getCantidad();
         return this.actualizarCantidadMuebleCarro(referencia, cantidad);
    }
    
    /**
     * Mantiene referencia al mueble que se quiere ver el detalle
     * @param referencia
     * @return 
     */
    public String verDetalle(String referencia){
        idDetalle = getPosMueble(referencia, mueblesVenta);
        this.setCantidadDetalle(mueblesVenta.get(idDetalle).getCantidad());
        return  "detalleMuebleView";
    }
    /**
     * Busca la posición de un mueble en un listado
     * @param referencia
     * @param listadoMuebles
     * @return 
     */
    private int getPosMueble(String referencia, List<MuebleVenta> listadoMuebles){
        int posicion = -1;
        boolean existe=false;
        for(int i=0; i<listadoMuebles.size() && !existe;i++){
            if(listadoMuebles.get(i).getMueble().getReferencia().equals(referencia)){
                existe =true;
                posicion = i;
            }
        }
        return posicion;
    }
    
    /**
     * Obtiene el mueble que se le quiere ver el detalle
     * @return 
     */
    public MuebleVenta getMuebleVenta(){
        return  mueblesVenta.get(idDetalle);
    }
    
    public void setMuebleVenta(MuebleVenta muebleVenta){
        this.mueblesVenta.get(idDetalle).setCantidad(muebleVenta.getCantidad());
    }
    
    
    /**
     * Devuelve los tipos de muebles
     * @return sitems Tipos de muebles en el sistema
     */
    public SelectItem[] getTiposMuebles()
    {
        TipoMueble[] tipos=  TipoMueble.values();
        SelectItem[] sitems = new SelectItem[tipos.length];
        
        for (int i = 0; i < sitems.length; i++)
        {
             sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }

    public int getCantidadDetalle() {
        return cantidadDetalle;
    }

    public void setCantidadDetalle(int cantidadDetalle) {
        this.cantidadDetalle = cantidadDetalle;
    }

    /**
     * Obtiene los muebles seleccionados para comprar
     * @return 
     */
    public List<MuebleVenta> getMueblesComprar(){
        List<MuebleVenta> mueblesCompra = new LinkedList<MuebleVenta>();
        for(MuebleVenta mueble : mueblesVenta){
            if(mueble.getCantidad()>0)
                mueblesCompra.add(mueble);
        }
        return  mueblesCompra;
    }
    
    /**
     * Obtiene el costo total de la compra
     * @return 
     */
    public int getCostoTotal(){
        int total=0;
        for(MuebleVenta mueble : mueblesVenta){
            if(mueble.getCantidad()>0)
                total += mueble.getCantidad()*mueble.getMueble().getPrecio();
        }
        return total;
    }
    
    public String cerrarCompra(){
        Ventas ventatmp =new Ventas();
        ventatmp.setFechaDeCompra(new Date());
        ventatmp.setMueblesVenta(this.getMueblesComprar());
        ventatmp.setTotal(Double.parseDouble((String.valueOf(this.getCostoTotal()))));
        Cliente c = new Cliente();
        c.setNombre(this.getLoginBean().getUsuario());
        c.setNumeroDocumento("--");
        ventatmp.setCliente(c);
        this.getReporteComprasBean().agregarVenta(ventatmp);
       
        return "listadoMueblesVenta";
        }
    
    public void limpiarCarroDeCompra(){
        for(int i=0;i<this.mueblesVenta.size();i++){
            this.mueblesVenta.get(i).setCantidad(0);
        }
    }
              
    
}
