package abem;

import java.util.List;

public interface ITareaDao<Param>{
    boolean agregar(Param p);
    boolean modificar(Param p);
    boolean eliminar(Param p);
    Param buscarPorId(Object p);
    List<Param> listarTodo();

}
