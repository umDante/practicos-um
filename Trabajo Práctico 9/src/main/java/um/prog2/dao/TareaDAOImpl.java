package um.prog2.dao;

import org.springframework.stereotype.Repository;
import um.prog2.modelo.Tarea;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
@Transactional
public class TareaDAOImpl extends AbstractDAO implements ITareaDAO{
    private final static Logger LOGGER = Logger.getLogger("um.prog2.dao.TareaDAOImpl");

    @Override
    public void registrar(Tarea tarea) throws Exception {
        LOGGER.log(Level.INFO, "############ registrar DAO ############");

        persist(tarea);
    }

    @Override
    public void modificar(Tarea tarea) throws Exception {
    update(tarea);
    }

    @Override
    public void eliminar(Tarea tarea) throws Exception {
    delete(tarea);
    }

    @Override
    public List<Tarea> listarTodos() throws Exception {
        LOGGER.log(Level.INFO, "listarTodos TareaDAOImpl");

        TypedQuery<Tarea> query=getSession().createQuery("from Tarea");
        return query.getResultList();
    }

    @Override
    public Tarea listarPorId(int id) throws Exception {
        List<Tarea> lista;
        String sql = "FROM Tarea WHERE id=:id";
        TypedQuery<Tarea> query = getSession().createQuery(sql);
        query.setParameter("id",id);
        lista=query.getResultList();
        Tarea tar = lista !=null && !lista.isEmpty() ? lista.get(0):new Tarea();
        return tar;
    }
}
