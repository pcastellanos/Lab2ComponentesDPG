/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.MuebleVenta;
import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.ServicioCatalogoMock;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author paulacastellanos
 */
@ManagedBean
@SessionScoped
public class CarroCompraBean {

    List<MuebleVenta> mueblesVenta;
    IServicioCatalogo catalogo;
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
    public void actualizarCantidadMuebleCarro(String referencia,int cantidad){
        int posicion = getPosMueble(referencia, mueblesVenta);
        mueblesVenta.get(posicion).setCantidad(cantidad);
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
    
}
