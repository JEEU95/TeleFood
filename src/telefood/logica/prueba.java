/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefood.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Jorge
 */
public class prueba {

    public static void main(String[] args) throws Exception {
        TeleFood pedidos = new TeleFood("wwecuado_tf", "T3l3f00d!\"");
        ArrayList<String> campo = new ArrayList();
        campo.add("DISTINCT DesdeId");
        Registro r = new Registro();
        r.setDatos(campo);
        r.setDatos("Pedido");
        ArrayList<Registro> registro = pedidos.listarDatos(r);
        campo = new ArrayList();
        for (Registro reg : registro) {
            campo.add(reg.getDatos().get(0).toString());
        }

        Collections.sort(campo, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return extractInt(o1) - extractInt(o2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                // return 0 if no digits found
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });

        for (String c : campo) {
            System.out.println(c);
        }
    }
}
