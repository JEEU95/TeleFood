
package telefood.datos;

/**
 *
 * @author Jorge
 */
public class Parametros_DB {
    
    String puerto="1521";
    String dbName="XE";
    String host="localhost";
    String URL="jdbc:oracle:thin:@"+host+":"+puerto+":"+dbName;
    String Driver="oracle.jdbc.driver.OracleDriver";
}
