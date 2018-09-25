package clasesgenericas;

import java.util.ArrayList;
import java.util.Iterator;
/*
 AL no  saber que tipo de Obj meteré, será generico <T> "cualquiera entra"
 */

public class Arreglogenerico<T> implements IAlmacenar<T>{

   private T arregloGenerico;

    public Arreglogenerico() {
        arregloGenerico=null;
    }


    public void agregar(T arregloGenerico) {
        this.arregloGenerico = arregloGenerico;
    }

    public T obtener(int posicion) {
        return arregloGenerico;
    }

    public void borrar(int posicion) {

    }

    public void borrarTodos() {

    }



}
