package dao;

import entidad.Tarea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;


public class TareaDao implements ITareaDao<Tarea> {
    /*Hibernate:SessionFactory y JPA:EntityManagerFactory
    HibernateTransactionManager y JpaTransactionManager
    javax.persistence.EntityManager y org.hibernate.SessionFactory
    */
    protected SessionFactory sf;
    public TareaDao() {
        this.sf = HibernateUtils.getSessionFactory();
    }

    public boolean agregar(Tarea t) {

        try{
        Session s = this.sf.openSession();
        s.beginTransaction();
        s.persist(t);
        s.getTransaction().commit();
        s.close();
        }catch (Exception e){
            System.err.println("No se pudo agregar la Tarea "+e);
            return false;
        }
        return true;
    }


    public boolean modificar (Tarea t) {

        try {
            Session s = this.sf.openSession();
            s.beginTransaction();
            s.update(t);
            s.getTransaction().commit();

        }
        catch (Exception e) {
            System.err.println("No se pudo hacer la modificación"+ e);
            return  false;
        }
        return true;
    }

    public boolean eliminar (Tarea t) {

        try{
            Session s = this.sf.openSession();
            s.beginTransaction();
            s.delete(t);
            s.getTransaction().commit();
            s.close();
        }catch (Exception e){
            System.err.println("No se pudo eliminar tarea "+e);
            return false;
        }
        return true;
    }
    public Tarea buscarPorId(Object id) {
        Session s= this.sf.openSession();
        String sql = "select t from Tarea t where t.id=:id";
        Query<Tarea> query = s.createQuery(sql);
        query.setParameter("id",id);
        Tarea resultado = query.getSingleResult();
        return resultado;
    }

    public List<Tarea> listarTodo() {
        Session s = this.sf.openSession();
        s.beginTransaction();
        String sql = "select t from Tarea t";
        Query<Tarea> query=s.createQuery(sql);
        List<Tarea> tareas = query.getResultList();
        s.getTransaction().commit();
        s.close();
        return tareas;
    }
}
/*
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


}
 */
