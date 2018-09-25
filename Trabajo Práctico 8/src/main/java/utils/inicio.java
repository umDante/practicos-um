package utils;

import dao.TareaDao;
import entidad.Tarea;


import java.util.ArrayList;
import java.util.List;


//RECORDAR: Antes de correr, eliminar la BD; luego el eliminar solo se observa desde la BD
public class inicio {
    public static void main(String[] args) {
        inicio ini = new inicio();
        ini.run();
    }

    public void run(){

        TareaDao tareadao = new TareaDao();

        Tarea t1 = new Tarea("2/9/18","formatear","pepito");
        Tarea t2 = new Tarea("8/9/18","particionar","coquito");
        Tarea t3 = new Tarea("4/9/18","Desfragmentar","jaimito");
        Tarea t4 = new Tarea("22/9/18","Cobrar","pablito");
        Tarea t5 = new Tarea("11/11/11","UNO","UNOUNO");
        tareadao.agregar(t1);
        tareadao.agregar(t2);
        tareadao.agregar(t3);
        tareadao.agregar(t4);
        tareadao.agregar(t5);
        System.out.println("TAREAS AGREGADAS ");




        /*
        Tarea t =tareadao.buscarPorId(1);

        System.out.println("BUSCANDO TAREA POR ID = 1 ");
        System.out.println("id "+t.getId()+"\ninicio "+t.getInicio()+"\nautor "+t.getAutor()+
                "\ndescripcion "+t.getDescripcion()+"\n");
         */


       /*
       List<Tarea> ts=tareadao.listarTodo();
            for(Tarea tt:ts){
            System.out.println("id "+tt.getId()+"\ninicio "+tt.getInicio()+"\nautor "+tt.getAutor()+
                    "\ndescripcion "+tt.getDescripcion()+"\n");
             }
            System.out.println("LISTADO DE TODAS LAS TAREAS");
        */

        /*
        tareadao.eliminar(t3); //REVISAR
        System.out.println("TAREAS t3 ELIMINADA");
        */

        t5.setAutor("NNNNNNNNNNNN");
        tareadao.modificar(t5);


    }
}
