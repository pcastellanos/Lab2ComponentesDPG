/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoBusqueda;
import java.util.List;

/**
 *
 * @author paulacastellanos
 */
public interface IServicioClientes {

    /**
     *  Obtiene el listado de clientes registrados en el sistema
     * @param tipoBusqueda
     * @param filtro
     * @return Listado de clientes segun el filtro, si filtro ==""  se retornan todos los clientes
     */
    public List<Cliente> Listar(TipoBusqueda tipoBusqueda, String filtro);
    
    /**
     * Agregar un cliente al sistema si no existe, en caso de existir lo actualiza.
     * @param cliente cliente nuevo
     * @return true si el cliente es adicionado, false en caso contrario
     */
    public boolean Agregar(Cliente cliente);
    
    /**
     * Eliminar un cliente
     * @param documento Documento del cliente que se debe eliminar del sistema
     * @return true si el cliente es eliminado, false en caso contrario
     */
    public boolean eliminar(String documento);

    public Cliente obtenerPorDocumento(String numeroDoc);
}
