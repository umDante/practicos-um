
/*Al instanciar clase paso driver -> saberEstado() retorna siempre solo una instancia */

package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBd {

    private static ConexionBd instanciaBd;
    private Connection connection;

    private ConexionBd() {
        try {
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/tp6c1","root",null);
        }catch (SQLException e){
            System.out.println("Error al registrar el driver de BD "+ e);
        }
    }
    /*si no hay instancia creada "null" creo una y la retorno*/
    public synchronized static ConexionBd saberEstadoBd() {
        if(instanciaBd==null){
            instanciaBd=new ConexionBd();
        }
        return instanciaBd;
    }

    public Connection getConnection(){
        return connection;
    }

    public void cerrarConexion(){
        instanciaBd=null;
    }

}
