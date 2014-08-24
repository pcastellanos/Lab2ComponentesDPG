/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Mueble.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.bos;

/**
 * Clase que representa la información de un mueble en el sistema
 * @author Juan Sebastián Urrego
 */
public class Mueble
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Referencia que identifica el modelo del mueble en el sistema.
     */
    private String referencia;

    /**
     * Nombre del mueble.
     */
    private String nombre;

    /**
     * Descripción del mueble.
     */
    private String descripcion;

    /**
     * Tipo de mueble.
     */
    private TipoMueble tipo;

    /**
     * Indica si el mueble fue seleccionado
     */
    private boolean seleccion;

    /**
     * Indica la cantidad existente del mueble
     */
    private int cantidad;
    
    /**
     * Indica el precio por unidad de mueble
     */
    private int precio;
    
    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public Mueble() 
    {

    }

    /**
     * Constructor de la clase. Inicializa los atributos con los valores que ingresan por parametro.
     * @param referencia Referencia del mueble
     * @param nombre Nombre del mueble
     * @param descripcion Descripión del mueble
     * @param tipo Tipo de mueble
     * @param precio precio del mueble
     * @param cantidad cantidad existente del mueble 
     */
    public Mueble(String referencia, String nombre, String descripcion, TipoMueble tipo, int precio, int cantidad)
    {
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.seleccion = false;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve la descripción del mueble
     * @return descripcion Descripción del mueble
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * Modifica la descripción del mueble
     * @param descripcion Nueva descripción del mueble
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el nombre del mueble
     * @return nombre Nombre del mueble
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Modifica el nombre del mueble
     * @param nombre Nuevo nombre del mueble
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * Devuelve la referencia del mueble
     * @return referencia Referencia del mueble
     */
    public String getReferencia()
    {
        return referencia;
    }

    /**
     * Modifica la referencia del mueble
     * @param referencia Nueva referencia del mueble
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * Devuelve el tipo de mueble
     * @return tipo Tipo de mueble
     */
    public TipoMueble getTipo()
    {
        return tipo;
    }

    /**
     * Modifica el tipo de mueble
     * @param tipo Nuevo tipo de mueble
     */
    public void setTipo(TipoMueble tipo)
    {
        this.tipo = tipo;
    }

    /**
     * Devuelve el estado de selección del mueble
     * @return seleccion Verdadero o falso
     */
    public boolean getSeleccion()
    {
        return seleccion;
    }

    /**
     * Cambia el estado de selección de un mueble
     * @param seleccion Nuevo estado de selección
     */
    public void setSeleccion(boolean seleccion)
    {
        this.seleccion = seleccion;
    }

    /**
     * Obtiene la cantidad existente del mueble
     * @return 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * actualiza la cantidad existente del mueble
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio del mueble
     * @return 
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * actualiza el precio del mueble
     * @param precio 
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }


     
}
