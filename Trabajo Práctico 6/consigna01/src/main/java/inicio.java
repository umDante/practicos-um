import abem.TareaDaoImpl;
import entidad.Tarea;

import java.util.ArrayList;

public class inicio {
    public static void main(String[] args) {

        TareaDaoImpl tareadao = new TareaDaoImpl();

        // Objetos ta en BD, id no puede ser dupicado
       /* Tarea tarea=new Tarea();
       //Revisado, anda!
        tarea.setId(3);
        tarea.setInicio("26/08/2018");
        tarea.setAutor("tres");
        tarea.setDescripcion("libro3");
        tareadao.agregar(tarea);

        Tarea tarea1=new Tarea();
        tarea1.setId(4);
        tarea1.setInicio("27/08/2018");
        tarea1.setAutor("cuatro");
        tarea1.setDescripcion("libro4");
        tareadao.agregar(tarea1);

        Tarea tarea2=new Tarea();
        tarea2.setId(5);
        tarea2.setInicio("28/08/2018");
        tarea2.setAutor("cinco");
        tarea2.setDescripcion("libro5");
        tareadao.agregar(tarea2);*/

        /*
        //Reviado, anda!
        Tarea tareaModificar= new Tarea();
        tareaModificar.setAutor("Pompín");
        tareaModificar.setDescripcion("El libro de Pompín");
        tareaModificar.setId(3);
        tareadao.modificar(tareaModificar);*/

        /*
        // Revisado, anda!
        Tarea tareaEliminar = new Tarea();
        tareaEliminar.setId(2);
        tareadao.eliminar(tareaEliminar);*/

        /*
        //Revisado, anda!
        Tarea tareaBuscarPorId;
        tareaBuscarPorId = tareadao.buscarPorId(4);
        System.out.println(tareaBuscarPorId.getAutor());*/

        //Tarea tareaListarTodo=new Tarea();
        ArrayList<Tarea> tareas;
        tareas = (ArrayList<Tarea>) tareadao.listarTodo();
        for(Tarea t:tareas){
            System.out.println("ID: "+t.getId());
            System.out.println("Autor: "+t.getAutor());
            System.out.println("Fecha Inicio: "+t.getInicio());
            System.out.println("Descripción: "+t.getDescripcion());
            System.out.println();
        }

    }
}
