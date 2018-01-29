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
        double a=5.4353;
        String b = String.format("%.2f", a).replaceAll(",", ".");
        double c = Double.parseDouble(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        
    }
}
