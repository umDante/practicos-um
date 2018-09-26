package um.prog2.consigna.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import um.prog2.consigna.entidad.Tarea;
import um.prog2.consigna.repositorio.ITareaRepositorio;

import java.util.List;

@Service
public class TareaServicioImpl implements ITareaServicio{

    @Autowired
    private ITareaRepositorio tareaRepositorio;
    @Override
    public List<Tarea> listarTodos() {
        return tareaRepositorio.findAll();
    }

    @Override
    public Tarea registrar(Tarea tar) {
        return tareaRepositorio.save(tar);
    }
    @Override
    public Tarea listarPorId(int id) {
        return tareaRepositorio.findById(id).orElse(null);
    }
    @Override
    public void eliminar(Tarea id) {
        tareaRepositorio.delete(id);
    }

    @Override
    public void modificar(Tarea tar) {
        tareaRepositorio.save(tar);
    }
}
