
package telefood.datos;

/**
 *
 * @author Jorge
 */
public class Parametros_DB {
    
    String puerto="3306";
    
    String dbName="wwecuado_telefood";
    String host="wwecuador.com";
    
    
    //String URL="jdbc:mysql://"+host+":"+puerto+"/"+dbName+"?";
    String URL="jdbc:mysql://wwecuador.com:3306/wwecuado_telefood?zeroDateTimeBehavior=convertToNull";
    
    //String URL="jdbc:oracle:thin:@"+host+":"+puerto+":"+dbName;
    
}
