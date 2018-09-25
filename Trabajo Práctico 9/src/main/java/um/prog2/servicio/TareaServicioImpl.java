package um.prog2.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.prog2.dao.ITareaDAO;
import um.prog2.modelo.Tarea;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TareaServicioImpl implements ITareaServicio{
    private final static Logger LOGGER = Logger.getLogger("um.prog2.servicio.TareaServicioImpl");

    @Autowired
    private ITareaDAO tarea;

    @Override
    public void registrar(Tarea tar) throws Exception {
        LOGGER.log(Level.INFO, "############ registrar Servicio ############");

        tarea.registrar(tar);
    }

    @Override
    public void modificar(Tarea tar) throws Exception {
        tarea.modificar(tar);
    }

    @Override
    public void eliminar(Tarea tar) throws Exception {
        tarea.eliminar(tar);
    }

    @Override
    public List<Tarea> listarTodos() throws Exception {
        LOGGER.log(Level.INFO, "listarTodos TareaServicioImpl");

        return tarea.listarTodos();
    }

    @Override
    public Tarea listarPorId(int id) throws Exception {
        return tarea.listarPorId(id);
    }
}
