/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.*;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author paulacastellanos
 */
public class ServicioClientesMock implements IServicioClientes {
     private List<Cliente> clientes;
    
     public ServicioClientesMock(){
        clientes = new LinkedList<Cliente>();
        clientes.add(new Cliente(TipoDocumento.Cedula,"1039456789", TipoCliente.Natural,"Andres Garcia","4345678","3124567890","Carrera 12A #150-12","Bogota","Cundinamarca","Colombia","Estudiante","agarcia@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.NIT,"11-1039456789", TipoCliente.Juridica,"Juan Cortes","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.NIT,"13-3242342234", TipoCliente.Juridica,"Felipe Garzon","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.NIT,"11-3243423442", TipoCliente.Juridica,"Angela Corso","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.Cedula,"2342423432424", TipoCliente.Natural,"Juan Diego Ojeda","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.NIT,"0980867854", TipoCliente.Juridica,"Camilo hernandez","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.Cedula,"454645242432", TipoCliente.Natural,"Nubia Medina","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.Cedula,"142343246789", TipoCliente.Natural,"Marcela Pelaez","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
        clientes.add(new Cliente(TipoDocumento.Cedula,"33464574734", TipoCliente.Natural,"José Castellanos","56789954","3124567890","Carrera 7 #127-12","Bogota","Cundinamarca","Colombia","Ingeniero de sistemas","jcortes@gmail.com"));
    }
    
     /**
     *  Obtiene el listado de clientes registrados en el sistema
     * @param tipoBusqueda
     * @param filtro
     * @return Listado de clientes segun el filtro, si filtro ==""  se retornan todos los clientes
     */
    @Override
    public List<Cliente> Listar(TipoBusqueda tipoBusqueda, String filtro) {
        List<Cliente> clientesTemp = filtro.equals("") ? clientes : buscarClientesFiltro(tipoBusqueda,filtro);
        return clientesTemp;
    }

    /**
     * Agregar un cliente al sistema
     * @param cliente cliente nuevo
     * @return true si el cliente es adicionado, false en caso contrario
     */
    @Override
    public boolean Agregar(Cliente cliente) {
        boolean agregado=false;
        int index;
        if(cliente!=null){
            index=buscarCliente(cliente.getNumeroDocumento());
            if(index!=-1)
              Actualizar(cliente, index);
            else{
                cliente.setTipo(cliente.getTipoDocumento() == TipoDocumento.Cedula? TipoCliente.Natural : TipoCliente.Juridica);
                clientes.add(cliente);
            }
            agregado = true;
        }
        return agregado;
    }

     /**
     * Eliminar un cliente
     * @param documento documento del cliente que se debe eliminar del sistema
     * @return true si el cliente es eliminado, false en caso contrario
     */
    @Override
    public boolean eliminar(String documento) {
       boolean eliminado =false;
       int tamano = clientes.size();
        for(int i=0;i<tamano && !eliminado;i++){
            if(clientes.get(i).getNumeroDocumento().equals(documento)){
                clientes.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }

    /**
     * Actualizar un cliente
     * @param cliente cliente que se quiere actualizar
     * @return true si el cliente es actualizado, false en caso contrario
     */
    private void Actualizar(Cliente cliente, int index) {
            clientes.get(index).setCelular(cliente.getCelular());
            clientes.get(index).setCiudad(cliente.getCiudad());
            clientes.get(index).setCorreo(cliente.getCorreo());
            clientes.get(index).setDepartamento(cliente.getDepartamento());
            clientes.get(index).setDireccion(cliente.getDireccion());
            clientes.get(index).setNombre(cliente.getNombre());
            clientes.get(index).setPais(cliente.getPais());
            clientes.get(index).setProfesion(cliente.getProfesion());
            clientes.get(index).setTelefono(cliente.getTelefono());    
    }
    
    /**
     * Busca un cliente por numero de identificación
     * @param numeroDocumento
     * @return 
     */
    private int buscarCliente(String numeroDocumento){
        int index=-1;
        int longitud = clientes.size();
        boolean encontrado=false;
        for(int i=0; i< longitud && !encontrado; i++){
            if(clientes.get(i).getNumeroDocumento().equals(numeroDocumento)){
                encontrado=true;
                index=i;
            }
        }
        return index;
    }

    /**
     * Busca los clientes que cumplan con el criterio de busqueda
     * @param tipoBusqueda
     * @param filtro
     * @return 
     */
    private List<Cliente> buscarClientesFiltro(TipoBusqueda tipoBusqueda, String filtro) {
        List<Cliente> clientesTemp= new LinkedList<Cliente>();
        
        switch(tipoBusqueda){
            case Correo:
                clientesTemp = buscarCorreo(filtro);
                break;
            case Direccion:
                clientesTemp = buscarDireccion(filtro);
                break;
            case Documento:
                clientesTemp = buscarDocumento(filtro);
                break;
            case Nombre:
                clientesTemp = buscarNombre(filtro);
                break;
        }
                
                
        return clientesTemp;
    }

    /**
     * Busca los clientes que cumplan con el correo enviado
     * @param filtro
     * @return 
     */
    private List<Cliente> buscarCorreo(String filtro) {
        List<Cliente> clientesTemp= new LinkedList<Cliente>();
        for(Cliente cliente : clientes){
            if(cliente.getCorreo().contains(filtro))
                clientesTemp.add(cliente);
        }
        return clientesTemp;
    }
    
    /**
     * Busca los clientes que cumplan con el documento enviado
     * @param filtro
     * @return 
     */
    private List<Cliente> buscarDocumento(String filtro) {
        List<Cliente> clientesTemp= new LinkedList<Cliente>();
        for(Cliente cliente : clientes){
            if(cliente.getNumeroDocumento().contains(filtro))
                clientesTemp.add(cliente);
        }
        return clientesTemp;
    }
    
    /**
     * Busca los clientes que cumplan con la dirección enviada
     * @param filtro
     * @return 
     */
    private List<Cliente> buscarDireccion(String filtro) {
        List<Cliente> clientesTemp= new LinkedList<Cliente>();
        for(Cliente cliente : clientes){
            if(cliente.getDireccion().contains(filtro))
                clientesTemp.add(cliente);
        }
        return clientesTemp;
    }
    
    /**
     * Busca los clientes que cumplan con el nombre enviado
     * @param filtro
     * @return 
     */
    private List<Cliente> buscarNombre(String filtro) {
        List<Cliente> clientesTemp= new LinkedList<Cliente>();
        for(Cliente cliente : clientes){
            if(cliente.getNombre().contains(filtro))
                clientesTemp.add(cliente);
        }
        return clientesTemp;
    }

    @Override
    public Cliente obtenerPorDocumento(String numeroDoc) {
        Cliente clienteTemp=null;
        for(Cliente cliente : clientes){
            if(cliente.getNumeroDocumento().equals(numeroDoc))
                clienteTemp = cliente;
        }
        return clienteTemp;
    }
}
