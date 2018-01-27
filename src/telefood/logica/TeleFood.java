package telefood.logica;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import telefood.datos.TeleFoodDatos;

/**
 *
 * @author Jorge
 */
public class TeleFood {

    //TablasDB tabla;
    
    TeleFoodDatos tabla=null;
    ArrayList<String> f;

    public TeleFood(String user, String pass) {
        //this.tabla = new TablasDB(user, pass);
        this.tabla = new TeleFoodDatos(user, pass);
    }

    public ArrayList<String> nombresTablas() throws SQLException, Exception {
        ArrayList<String> tab = new ArrayList();
        //Formacion del objeto f(se le indica q parametros considerar en la consulta )
        f = new ArrayList();
        f.add("TABLE_NAME");
        f.add("USER_TABLES");
        Object o = f;
        //ResultSet rs = tabla.consulta("TABLE_NAME", "USER_TABLES", ""); //Realizar consulta
        ResultSet rs = tabla.consulta(o); //Realizar consulta
        while (rs.next()) {
            tab.add(rs.getString("TABLE_NAME")); //Extracion de los datos en el campo "TABLE_NAME"
        }
        //retornar el listado de nombres de tablas
        return tab;

        //  return tab.ListarTablas();
    }

    public ArrayList<String> camposTabla(String nom) throws SQLException, Exception {
        ArrayList<String> campos = new ArrayList();
        //SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME='" + tab + "'
        f = new ArrayList();
        
        f.add("COLUMN_NAME");
        f.add("INFORMATION_SCHEMA.COLUMNS");
        f.add("WHERE TABLE_NAME='" + nom + "'");
        Object o = f;
//        ResultSet rs = tabla.consulta("COLUMN_NAME", "USER_TAB_COLUMNS", "TABLE_NAME='" + nom + "'");
        ResultSet rs = tabla.consulta(o);
// ResultSet rs = tab.prueba(nom);
        while (rs.next()) {
            campos.add(rs.getString("COLUMN_NAME")); //Extraer y guardar los datos de la consulta
            //["id,nombre,apellido","persona","id<15"]
        }
        return campos;
        //return tab.ListarCampos(nom);
    }

    public void insertarDatos(String nom, Registro reg) throws SQLException, Exception {
        String val = "";
        //Se recoje los datos obtenidos en la capa de presentacion y se transforma o toma valores para
        //mandar a un ojecto del tipo Formato
        int i = reg.getDatos().size();
        for (Object r : reg.getDatos()) {
            i--;
            //En caso de que el objeto enviado se del tipo date
            if (((String) r).contains("DATE")) {
                String d = (String) r;
                //Cambiar el formato en caso de ser una fecha
                d = d.substring(0, d.length() - 4);
                val += "TO_DATE('" + d + "' ,'yyyy-mm-dd')";
            } else {
                val += "'" + r + "'";
            }
            if (i != 0) {
                val += ",";
            }
        }
        f = new ArrayList();
        f.add(nom);
        f.add(val);
        f.add("TABLE_NAME='" + nom + "'");
        Object o = f;
        

        tabla.registrar(o);

        //tabla.InsertarDatos(nom, reg, camposTabla(nom));
    }

    public void eliminarDatos(String nom, ArrayList<String> campC) throws SQLException, Exception {
        String claves = "";
        int i = campC.size();
        for (String c : campC) {
            i--;
            claves += c;
            if (i != 0) {
                claves += " AND ";
            }
        }
        f = new ArrayList();
        f.add(nom);
        f.add(claves);
        Object o = f;
        tabla.eliminar(o);
    }

    public void editarDatos(String nom, ArrayList<String> campC, ArrayList<String> campE) throws SQLException, Exception {
        //nombre, campo claves, campo editar, valores nuevos
        String claves = "", editar = "";
        int i = campC.size();
        int j = campE.size();
        for (String c : campC) {
            i--;
            claves += c;
            if (i != 0) {
                claves += " AND ";
            }
        }

        for (String e : campE) {
            j--;
            editar += e;
            if (j != 0) {
                editar += ",";
            }
        }
        f = new ArrayList();
        f.add(nom);
        f.add(editar);
        f.add(claves);
        Object o = f;

        tabla.modificar(o);
    }

    public ArrayList<Registro> listarRegistros(String nom) throws SQLException, Exception {
        ArrayList<Registro> reg = new ArrayList();
        ArrayList<String> campos = camposTabla(nom);
        f = new ArrayList();
        f.add("*");
        f.add(nom);
       // f.add("ORDER BY "+campos.get(0)+" ASC");
        Object o = f;

        ResultSet rs = tabla.consulta(o);
        while (rs.next()) {
            Registro datos = new Registro();//Creacion de un nuevo objeto Registro
            //leer celda por celda y almacenar los datos en el objeto
            for (String c : campos) {
                
                datos.setDatos(rs.getString(c));//llena el objeto con los campos obtenidos, (Dentrode los parentesis va la columna a buscar)
            }

            reg.add(datos);//Guardar el objeto obtenido en una lista
        }

        return reg;

        // return tab.ListarDatos(nom);
    }

    public ArrayList<Registro> listarDatos(Object o) throws SQLException, Exception {
        ArrayList<Registro> reg = new ArrayList();
        Registro f = (Registro) o;
        ArrayList<String> aux = new ArrayList();
        String cam = "";
        ArrayList<String> campos = (ArrayList<String>) f.getDatos().get(0);
        int i = campos.size();
        for (String c : campos) {
            i--;
            cam += c;
            if (i > 0) {
                cam += ", ";
            }
        }

        aux.add(cam);
        aux.add((String) f.getDatos().get(1));
        try {
            aux.add((String) f.getDatos().get(2));
        } catch (Exception e) {
            System.out.println("Error al listar datos");
            System.out.println(e.getMessage());
        }
        o = (Object) aux;

        ResultSet rs = tabla.consulta(o);
        
        if (rs != null) {
            while (rs.next()) {
                Registro datos = new Registro();//Creacion de un nuevo objeto Registro
                //leer celda por celda y almacenar los datos en el objeto
                for (String c : campos) {
                    
                    datos.setDatos(rs.getString(c));//llena el objeto con los campos obtenidos, (Dentrode los parentesis va la columna a buscar)
                }

                reg.add(datos);//Guardar el objeto obtenido en una lista
            }
        }

        return reg;

        // return tab.ListarDatos(nom);
    }
    
    public void ejecutar(Object o) throws SQLException, Exception{
        tabla.ejecutar(o);
    }

}
