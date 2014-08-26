/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author xDEAMx
 */
public class Ventas {
    private List<MuebleVenta> mueblesVenta;
    private Cliente cliente;
    private Double total;
    private Date fechaDeCompra;

    public List<MuebleVenta> getMueblesVenta() {
        if(mueblesVenta==null)
            mueblesVenta = new LinkedList<MuebleVenta>();
        return mueblesVenta;
    }

    public void setMueblesVenta(List<MuebleVenta> mueblesVenta) {
        this.getMueblesVenta().addAll(mueblesVenta);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(Date fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }
   
}
