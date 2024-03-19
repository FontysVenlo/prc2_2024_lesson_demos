/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projecta;

import com.mycompany.projectb.Calculator;
import java.util.ServiceLoader;

/**
 *
 * @author ibrahimkouzak
 */
public class ProjectA {

    public static void main(String[] args) {
        
        // Calculator cal = new CalculatorImp();
        ServiceLoader<Calculator> loader = ServiceLoader.load(Calculator.class);
        Calculator cal = loader.findFirst().get();
        
        System.out.println(" 2 + 3 = " + cal.add(2, 3));
    }
}
 