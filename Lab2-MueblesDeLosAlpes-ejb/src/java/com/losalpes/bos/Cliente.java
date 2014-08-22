/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

/**
 *
 * @author paulacastellanos
 */
public class Cliente {
 
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private TipoCliente tipo;
    private String nombre;
    private String telefono;
    private String celular;
    private String direccion;
    private String ciudad;
    private String departamento;
    private String pais;
    private String profesion;
    private String correo;

    public Cliente(){
        tipoDocumento = TipoDocumento.Cedula;
        tipo = TipoCliente.Natural;
        numeroDocumento ="";
    }
    
    public Cliente(TipoDocumento tipoDocumento, String numeroDocumento, TipoCliente tipo, String nombre, String telefono, String celular, String direccion, String ciudad, String departamento, String pais, String profesion, String correo) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.tipo = tipo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
        this.profesion = profesion;
        this.correo = correo;

    }

    /**
     * @return Tipo de documento del cliente
     */
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento Tipo de documento del cliente 
     */
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return numero de documento del cliente
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento número de documento del cliente
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return tipo de cliente 
     */
    public TipoCliente getTipo() {
        return tipo;
    }

    /**
     * 
     * @param tipo tipo de cliente 
     */
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    /**
     * @return Nombre completo del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nombre completo del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Telefono residencial del cliente
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * @param telefono Telefono residencial del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return Número del celular del cliente
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular Número del celular del cliente
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return Dirección residencial del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion Dirección residencial del cliente
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return Ciudad de residencia del cliente
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad Ciudad de residencia del cliente
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return Nombre del departamento de residencia del cliente
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento Nombre del departamento de residencia del cliente
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return Nombre del pais de residencia del cliente
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais Nombre del pais de residencia del cliente
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return Porfesión del cliente
     */
    public String getProfesion() {
        return profesion;
    }
    
    /**
     * @param profesion  Porfesión del cliente
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * @return Correo electronico del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo Correo electronico del cliente
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
   

    
}
