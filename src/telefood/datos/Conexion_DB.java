package telefood.datos;

//import Datos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Conexion_DB {
//Creacion de la clase para establecer la conexion con la BD    

    public static Connection conectar(String user, String pass) {
        try {
            String url = "jdbc:mysql://wwecuador.com:3306/";
            String dbName = "wwecuado_telefood";

            String driver = "com.mysql.jdbc.Driver";
            String userName = "wwecuado_tf"; 
            String password = "T3l3f00d!\"";  
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Todo bien.");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println("Error al conectar DB");
        }/*
        try {
            Parametros_DB pc=new Parametros_DB();
          
            String BD = pc.URL;
            System.out.println(BD);
            //Establece la conexion con (BD, "HR", "1234");
            Connection cnx = DriverManager.getConnection(BD,user, pass);
            System.out.println("**********************");
            return cnx;
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la BD");
        }*/
        return null;
    }

    public void cerrar(Connection cnx) throws SQLException {
        //Método para cerrar la conexion
        if (cnx != null) {
            if (!cnx.isClosed()) {
                cnx.close();
            }
        }
    }

}
