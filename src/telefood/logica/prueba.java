/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefood.logica;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class prueba {

    public static void main(String[] args) throws Exception {
        TeleFood pedidos = new TeleFood("wwecuado_tf", "T3l3f00d!\"");
        String ci = "'0105344048'";
        ArrayList<Registro> reg = new ArrayList();
        ArrayList<String> param = new ArrayList();
        param.add("Telefono");
        param.add("ClienteId=" + ci);
        String tlf = "";
        if (!ci.equals("")) {

            try {
                reg = pedidos.listarRegistros((Object) param);
                int nt = reg.size();
                for (Registro r : reg) {
                    
                    nt--;
                    tlf += r.getDatos().get(1);
                    if (nt > 0) {
                        tlf += ", ";
                    }

                }
                System.out.println(tlf);

            } catch (Exception e) {
                System.out.println("No esta registrado");
            }
        }
    }
}
