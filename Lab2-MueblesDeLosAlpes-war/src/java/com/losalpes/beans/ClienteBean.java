/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoBusqueda;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.servicios.IServicioClientes;
import com.losalpes.servicios.ServicioClientesMock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author paulacastellanos
 */
@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean {

    private IServicioClientes clientesMock;
    private Cliente cliente;
    private TipoBusqueda tipoBusqueda;
    private String filtroBusqueda;
    private Cliente clienteSeleccionado;
    
    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
        clientesMock = new ServicioClientesMock();
        tipoBusqueda = TipoBusqueda.Nombre;
        filtroBusqueda ="";
        
    }

    /**
     * Obtiene el cliente
     * @return 
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente
     * @param cliente 
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
     * Acción para activar la busqueda
     * @return 
     */
    public String buscar(){
        return "clientesView";
    }
  
    /**
     * Obtiene todos los clientes
     * @return 
     */
    public List<Cliente> getClientes(){
        return clientesMock.Listar(tipoBusqueda, filtroBusqueda);
        
    }
    
    /**
     * Devuelve los tipos de documentos que puede tener un cliente
     * @return tipos de documentos
     */
    public SelectItem[] getTiposDocumento()
    {
        TipoDocumento[] tipos=  TipoDocumento.values();
        SelectItem[] items = new SelectItem[tipos.length];
        
        for (int i = 0; i < items.length; i++)
        {
             items[i] = new SelectItem(tipos[i]);
        }
        return items;
    }
    
    /**
     * Obtiene los posibles tipos de busqueda a realizar sobre los clientes
     * @return 
     */
    public SelectItem[] getTiposBusqueda(){
       TipoBusqueda[] tipos=  TipoBusqueda.values();
        SelectItem[] items = new SelectItem[tipos.length];
        
        for (int i = 0; i < items.length; i++)
        {
             items[i] = new SelectItem(tipos[i]);
        }
        return items; 
    }
    
    /**
     * Asigna el criterio por el cual se realizará la busqueda de clientes
     * @param tipoBusqueda 
     */
    public void setTipoBusqueda (TipoBusqueda tipoBusqueda){
        this.tipoBusqueda = tipoBusqueda;
    }
    
    /**
     * Retorna el criterio por el cual se realizará la busqueda de clientes
     * @return tipo de busqueda a realizar
     */
    public TipoBusqueda getTipoBusqueda (){
        return tipoBusqueda;
    }

    /**  
     * @return palabra que se va buscar
     */
    public String getFiltroBusqueda() {
        return filtroBusqueda;
    }

    /**
     * Asigna el criterio de busqueda
     * @param filtroBusqueda 
     */
    public void setFiltroBusqueda(String filtroBusqueda) {
        this.filtroBusqueda = filtroBusqueda;
    }
    
    /**
     * Selecciona el cliente que se debe editar
     * @return nombre ed la vista de edición
     */
    public String seleccionarCliente(String numeroDoc){
        if(numeroDoc.length()==0)
            clienteSeleccionado = new Cliente();
        else
            clienteSeleccionado = clientesMock.obtenerPorDocumento(numeroDoc);
        
        return "irModificarCliente";
    }
    
    /**
     * Vuelve a la vista principal del administrador
     * @return 
     */
    public String volverAdmin(){
        filtroBusqueda ="";
        return  "regresarMenu";
    }
    
    /**
     * Vuelve al listado de clientes
     * @return 
     */
    public String volverListado(){
        filtroBusqueda ="";
        return  "irListadoClientes";
    }
    
    /**
     * Guardar un cliente
     * @return 
     */
    public String guardar(){
        clientesMock.Agregar(clienteSeleccionado);
        filtroBusqueda = "";
        return "clientesView";
    } 

    /**
     * Obtiene el cliente que se esta editando
     * @return 
     */
    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    /**
     * Asigna el cliente a editar
     * @param clienteSeleccionado 
     */
    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }
    
    /**
     * Elimina cliente
     * @param documento 
     */
    public String eliminarCliente(String documento) {
        clientesMock.eliminar(documento);
        return "clientesView";
    }
    
    
}
