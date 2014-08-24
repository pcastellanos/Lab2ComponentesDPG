/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCatalogoMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoMueble;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementacion de los servicios del catalogo de muebles que se le prestan al sistema. [Mock Object]
 * @author Juan Sebastián Urrego
 */

public class ServicioCatalogoMock implements IServicioCatalogo
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con los muebles del sistema
     */
    private ArrayList<Mueble> muebles;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioCatalogoMock()
    {

        //Inicializa el arreglo de los muebles
        muebles=new ArrayList<Mueble>();

        //Agrega los muebles del sistema
        muebles.add(new Mueble("RF1","Silla clásica","Una confortable silla con estilo del siglo XIX.",TipoMueble.Interior,100000,123));
        muebles.add(new Mueble("RF2","Silla moderna","Lo último en la moda de interiores. Esta silla le brindará la comodidad e innovación que busca",TipoMueble.Interior,200000,100));
        muebles.add(new Mueble("RF3","Mesa de jardín","Una bella mesa para comidas y reuniones al aire libre.",TipoMueble.Exterior,125000, 788));
        muebles.add(new Mueble("RF4","Sillón new wave","Innovador y cómodo. No existen mejores palabras para describir este hermoso sillón.",TipoMueble.Interior, 150000,1000));
        muebles.add(new Mueble("RF5","Mesa para comedor","Sus cenas no tendrán mejor acompañante. Una mesa para seis personas con un hermoso diseño clásico.",TipoMueble.Interior, 300000,500));
        muebles.add(new Mueble("RF6","Cama king","Una hermosa cama hecha en cedro para dos personas. Sus sueños no volveran a ser iguales.",TipoMueble.Interior, 125000,100 ));
        muebles.add(new Mueble("RF7","Silla de jardín","Una bella silla para comidas y reuniones al aire libre.",TipoMueble.Exterior,50000,200));
        muebles.add(new Mueble("RF8","Camarote junior","Con diseño moderno. Sus hijos ahora podrán tener unos felices sueños.",TipoMueble.Interior,140000,500));

    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un mueble al sistema
     * @param mueble Nuevo mueble
     */
    @Override
    public void agregarMueble(Mueble mueble)
    {
        muebles.add(mueble);
    }

    /**
     * Devuelve los muebles del sistema
     * @return muebles Arreglo con todos los muebles del sistema
     */
    @Override
    public List<Mueble> darMuebles()
    {
        return muebles;
    }

    @Override
    public Mueble buscarMueble(String referencia) {
        Mueble mueble=null;
        
        for(Mueble muebleTemp : muebles){
            if(muebleTemp.getReferencia().equals(referencia)){
                mueble = muebleTemp;
                break;
            }
        }
        
        return  mueble;
    }

    @Override
    public void editarPrecio(List<Mueble> mueblesEditar) {
        Mueble muebleEditar;
       for(Mueble mueble : mueblesEditar) 
       {
           muebleEditar = buscarMueble(mueble.getReferencia());
           if(muebleEditar!=null){
               muebleEditar.setCantidad(mueble.getCantidad());
               muebleEditar.setPrecio(mueble.getPrecio());
           }
       }
    }

}
