package um.prog2.consigna.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import um.prog2.consigna.entidad.Tarea;
import um.prog2.consigna.servicio.ITareaServicio;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tarea")
public class TareaControlador {


    @Autowired
    private ITareaServicio tareaServicio;

    public static final Logger logger = LoggerFactory.getLogger(TareaControlador.class);
    //---------------------------------LISTAR TAREAS  -----------------------------------------------
    @GetMapping(value = "/listarTareas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tarea>> listarTodo() {
        List<Tarea> tareas = new ArrayList<>();
        try {
            tareas = tareaServicio.listarTodos();
            logger.info("La tarea  están listadas correctamente");
        } catch (Exception e) {
            logger.error("Error al listar Tarea");
            new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Tarea>>(tareas, HttpStatus.OK);
    }

    //--------------------------------- CREAR PUBLICAR TAREA -----------------------------------------------
    @PostMapping(value = "/agregarTarea", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tarea> agregar(@RequestBody Tarea tar) {
        logger.info("Creando la tarea", tar);
        Tarea tarea = new Tarea();
        try {
            tarea = tareaServicio.registrar(tar);
            logger.info("Creada la tarea c/autor:", tar.getAutor());

        } catch (Exception e) {
            logger.error("Error al crear la tarea", e.getMessage());
            return new ResponseEntity<Tarea>(tarea, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
    }

    //---------------------------------BUSCAR TAREA POR ID -----------------------------------------------

    @GetMapping(value = "/listarTarea/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tarea> listarPorId(@PathVariable("id") Integer id) {
        Tarea tarea = new Tarea();
        try {
            tarea = tareaServicio.listarPorId(id);
            logger.info("Listada la tarea c/id:", id);

        } catch (Exception e) {
            logger.error("Error al listar la tarea", e.getMessage());
            new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
    }


    //--------------------------------- ELIMINAR TAREA -----------------------------------------------
    @DeleteMapping(value = "/eliminarTarea/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //  public ResponseEntity< ? > eliminar(@PathVariable Integer id){
    public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
        int eliminado = 0;
        try {
            tareaServicio.eliminar(tareaServicio.listarPorId(id));
            logger.info("Eliminada la tarea c/id:", id);
            eliminado = 1;
        } catch (Exception e) {
            logger.error("Error al eliminar la tarea", id, e.getMessage());
            eliminado = 0;
        }
        return new ResponseEntity<Integer>(eliminado, HttpStatus.OK);
    }

    //--------------------------------- MODIFICAR TAREAS -----------------------------------------------
    @PutMapping(value = "/modificarTarea", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> modificar(@RequestBody Tarea tar) {
        int mdificado = 0;
        try {
            tareaServicio.modificar(tar);
            logger.info("Modificada la tarea c/id:", tar.getId());
            mdificado = 1;
        } catch (Exception e) {
            mdificado = 0;
            logger.error("Error al modificar la tarea", e.getMessage());
        }
        return new ResponseEntity<Integer>(mdificado, HttpStatus.OK);
    }

}
