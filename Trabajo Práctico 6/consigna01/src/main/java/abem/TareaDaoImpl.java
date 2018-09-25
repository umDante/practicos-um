package abem;

import config.ConexionBd;
import entidad.Tarea;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TareaDaoImpl implements ITareaDao<Tarea> {
    private static final String SQL_INSERT="INSERT INTO tarea (id,inicio,autor,descripcion) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE tarea SET autor=?,descripcion=? WHERE id=?";
    private static final String SQL_DELETE="DELETE FROM tarea WHERE id=?";
    private static final String SQL_LIST="SELECT * FROM tarea WHERE id=?";
    private static final String SQL_LIST_ALL="SELECT * FROM tarea";



    private static final ConexionBd conexionBD= ConexionBd.saberEstadoBd();

    public boolean agregar(Tarea t) {
        PreparedStatement ps;
        try{
            ps=conexionBD.getConnection().prepareStatement(SQL_INSERT);

            ps.setInt(1,t.getId());
            ps.setString(2,t.getInicio());//fecha
            ps.setString(3,t.getAutor());
            ps.setString(4,t.getDescripcion());
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch (SQLException eSql){
            System.out.println("Error al crear y agregar la BD"+eSql);
        }
        finally{
            conexionBD.cerrarConexion();
        };
        return false;
    }

    public boolean modificar(Tarea t) {
        PreparedStatement ps;
        try {
            ps=conexionBD.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1,t.getAutor());//fecha
            ps.setString(2,t.getDescripcion());
            ps.setInt(3,t.getId());
            if(ps.executeUpdate()>0){
                return true;
            }

        }catch (SQLException eSql){
            System.out.println("Error al modificar en la BD "+eSql );
        }finally {
            conexionBD.cerrarConexion();
        }
        return false;
    }

    public boolean eliminar(Tarea t) {
        PreparedStatement ps;
        try{
           ps=conexionBD.getConnection().prepareStatement(SQL_DELETE);
           ps.setInt(1,t.getId());
           if(ps.executeUpdate()>0){
               return  true;
           }
        }catch (SQLException eSql){
            System.out.println("Error al eliminar Tarea "+eSql);
        }finally {
            conexionBD.cerrarConexion();
        }
        return false;
    }

    public Tarea buscarPorId(Object t) {
        PreparedStatement ps; // precompilo sentencia sql
        Tarea tareaId = new Tarea();
        ResultSet rs; //Consigue datos de la consulta y da acceso a las filas

        try{
            ps=conexionBD.getConnection().prepareStatement(SQL_LIST);
            //Busco objeto asociado a la clave
            ps.setInt(1,t.hashCode());//obtiene un código hash (~ id del objeto) pa ubicar elemento
            rs=ps.executeQuery();// executo la consulta
            while (rs.next()){
                //paso numero de columna en tabla de BD
                tareaId = new Tarea(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        }catch (SQLException eSql){
            System.out.println("Error al buscar tarea por ID "+eSql);
        }finally {
            conexionBD.cerrarConexion();
        }
        return tareaId;
    }

    public List<Tarea> listarTodo() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Tarea> tareas = new ArrayList();

        try{
            ps=conexionBD.getConnection().prepareStatement(SQL_LIST_ALL);
            rs=ps.executeQuery();
            while(rs.next()){
                tareas.add(new Tarea(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        }catch (Exception e){
            System.out.println("Error al leer todas tarea "+e);

        }finally {
            conexionBD.cerrarConexion();
        }
        return tareas;
    }
}
