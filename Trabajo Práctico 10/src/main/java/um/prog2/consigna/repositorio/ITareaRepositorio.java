package um.prog2.consigna.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import um.prog2.consigna.entidad.Tarea;

@Repository
public interface ITareaRepositorio extends JpaRepository<Tarea,Integer> {

}
