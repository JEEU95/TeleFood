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
    TeleFoodDatos tabla = null;
    ArrayList<String> f;
    String user, pass;

    public TeleFood(String user, String pass) {
        //this.tabla = new TablasDB(user, pass);
        this.tabla = new TeleFoodDatos(user, pass);
    }

    public ArrayList<String> camposTabla(String nom) throws SQLException, Exception {
        ArrayList<String> campos = new ArrayList();
        //SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME='" + tab + "'
        f = new ArrayList();

        f.add("COLUMN_NAME");
        f.add("INFORMATION_SCHEMA.COLUMNS");
        f.add("TABLE_NAME='" + nom + "'");
        Object o = f;
        ResultSet rs = tabla.consulta(o);

        while (rs.next()) {
            campos.add(rs.getString("COLUMN_NAME")); //Extraer y guardar los datos de la consulta
            
        }
        return campos;
        
    }

    public void insertarDatos(String nom, Registro reg) throws SQLException, Exception {
        String val = "";
        //Se recoje los datos obtenidos en la capa de presentacion y se transforma o toma valores para
        //mandar a un ojecto del tipo Formato
        int i = reg.getDatos().size();
        for (Object r : reg.getDatos()) {
            i--;
            //********************************FALTA VALIDAR FECHA y TIEMPO****************
            if(r==null || r.equals("DEFAULT")){
                val+=r;
            }else{
                boolean isNumero = false;
                try{
                    int numero = Integer.parseInt(r.toString());
                    isNumero = true;
                } catch (NumberFormatException ne){
                    try {
                        double decimal = Double.parseDouble(r.toString());
                        isNumero = true;
                    } catch (NumberFormatException ne2){
                        ne2.getMessage();
                    }
                }
                if (isNumero){
                    val += r;
                } else {
                    if (r.toString().contains("(") || r.toString().contains("'")){
                        val += r;
                    } else {
                        val += "'" + r + "'";
                    }
                }
 
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

    public ArrayList<Registro> listarRegistros(Object o) throws SQLException, Exception {
        /*
        Lista el registro completo
        */
        ArrayList<String> parametros = (ArrayList) o;
        String nom= parametros.get(0);
        ArrayList<String> campos = camposTabla(nom);
        f = new ArrayList();
        f.add("*");
        f.add(nom);
        
        try{
            String con = parametros.get(1);
            f.add(con);
        }catch (Exception e){
            System.out.println(e);
        }
        ArrayList<Registro> reg = new ArrayList();
        

        
        Object obj = f;

        ResultSet rs = tabla.consulta(obj);
        
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
        /*
        Lista los registros de campos específicos
        */
        
        ArrayList<Registro> reg = new ArrayList();
        Registro f = (Registro) o;
        ArrayList<String> aux = new ArrayList();
        String cam = "";
        ArrayList<String> campos = (ArrayList<String>) f.getDatos().get(0);
        
        
        //Array String, String, String
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
            System.out.println("No existe condicion listarDatos");
        }
        o = (Object) aux;

        ResultSet rs = tabla.consulta(o);

        if (rs != null) {

            while (rs.next()) {

                Registro datos = new Registro();//Creacion de un nuevo objeto Registro
                //leer celda por celda y almacenar los datos en el objeto
                for (String c : campos) {
                    
                    c=c.replaceAll("DISTINCT ", "");
                    datos.setDatos(rs.getString(c));//llena el objeto con los campos obtenidos, (Dentrode los parentesis va la columna a buscar)
                }
                
                reg.add(datos);//Guardar el objeto obtenido en una lista
            }
        }

        return reg;

        // return tab.ListarDatos(nom);
    }
/*
    public void ejecutar(Object o) throws SQLException, Exception {
        tabla.ejecutar(o);
    }
*/
}
