package um.prog2.dao;

import um.prog2.modelo.Tarea;

import java.util.List;

public interface ITareaDAO {
    void registrar(Tarea tarea) throws Exception;
    void modificar(Tarea tarea) throws Exception;
    void eliminar(Tarea tarea) throws Exception;
    List<Tarea> listarTodos() throws Exception;
    Tarea listarPorId(int id) throws Exception;
}
