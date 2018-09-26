package um.prog2.consigna.servicio;

import um.prog2.consigna.entidad.Tarea;

import java.util.List;

public interface ITareaServicio {
    List<Tarea> listarTodos();
    Tarea registrar(Tarea tar);
    Tarea listarPorId(int id);
    void eliminar(Tarea id) ;
    void modificar(Tarea tar);

}
