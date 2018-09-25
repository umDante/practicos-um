package um.prog2.servicio;

import um.prog2.modelo.Tarea;

import java.util.List;

public interface ITareaServicio {
    void registrar(Tarea tar) throws Exception;
    void modificar(Tarea tar) throws Exception;
    void eliminar(Tarea tar) throws Exception;
    List<Tarea> listarTodos() throws Exception;
    Tarea listarPorId(int id) throws Exception;
}
