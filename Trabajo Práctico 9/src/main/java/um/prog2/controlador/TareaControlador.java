package um.prog2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import um.prog2.modelo.Tarea;
import um.prog2.servicio.ITareaServicio;

import java.util.logging.Level;
import java.util.logging.Logger;


/*Preguntar TareaDAO*/
/*Tarea tar = lista !=null && !lista.isEmpty() ? lista.get(0):new Tarea();*/
@Controller

public class TareaControlador {
    private final static Logger LOGGER = Logger.getLogger("um.prog2.controlador.TareaControlador");
    @Autowired
    private ITareaServicio servicio;

    @RequestMapping(value = "/", method = RequestMethod.GET)

        public ModelAndView irTareas() throws Exception{
        LOGGER.log(Level.INFO, "####irTareas TareaControlador#####");

        return new ModelAndView("listaTareas", "tareas", servicio.listarTodos());
    }
    @RequestMapping(value = "/irRegistrar", method = RequestMethod.GET)
    public ModelAndView redireccion() {
        return new ModelAndView("tarea", "command", new Tarea());
    }

    @RequestMapping(value = "/irEditar", method = RequestMethod.GET)
    public ModelAndView irEditar(@RequestParam(value = "id") String id) throws Exception {
        LOGGER.log(Level.INFO, "/////////////////////////////////////////IrEditar controlador");
        /*Asi referencia spring a los formularios , con " controlador, anda al formulario "command"*/
        return new ModelAndView("tarea", "command", servicio.listarPorId(Integer.parseInt(id)));

    }

    @RequestMapping(value = "/remover", method = RequestMethod.GET)
    public ModelAndView remover(@RequestParam(value = "id") String id) throws Exception {
        if (id != null && Integer.parseInt(id) > 0) {
            Tarea tar = servicio.listarPorId(Integer.parseInt(id));
            if (tar != null) {
                servicio.eliminar(tar);
            }
        }
        return new ModelAndView("/listaTareas", "tareas", servicio.listarTodos());
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public ModelAndView registrar(Tarea tarea, ModelMap model) throws Exception {
        if( (tarea.getAutor()==null) || (tarea.getDescripcion()==null) || (tarea.getInicio()==null)){
           servicio.listarTodos();
        }else{
            //LOGGER.log(Level.INFO, "############ registrar Controlador ############");

            //LOGGER.log(Level.INFO, "Entro a registrar de controlador"+ tarea.getAutor() + "uuuuuuu");

            try {
                if (tarea.getId() == 0) {
                    //LOGGER.log(Level.INFO, "Entró a control getPid = 0 ");
                    servicio.registrar(tarea);
                } else {
                    //LOGGER.log(Level.INFO, "Entró a control getPid != 0 ");
                    servicio.modificar(tarea);
                }
            } catch (Exception e) {
         /*   LOGGER.log(Level.INFO, "Entró a Control catch ");
            LOGGER.log(Level.INFO, "Entro a registrar de controlador"+ tarea.getId() + "ID");
            LOGGER.log(Level.INFO, "Entro a registrar de controlador"+ tarea.getAutor() + "AUTOR");
            LOGGER.log(Level.INFO, "Entro a registrar de controlador"+ tarea.getInicio() + "INICIO");
            LOGGER.log(Level.INFO, "Entro a registrar de controlador"+ tarea.getDescripcion() + "DESCRIPCION");
        */
                System.out.print(e.getMessage());
            }
        }

       // LOGGER.log(Level.INFO, "Por legar a return de control");

        return new ModelAndView("listaTareas", "tareas", servicio.listarTodos());
    }
}
