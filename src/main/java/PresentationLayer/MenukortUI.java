/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Pizza;
import java.util.ArrayList;

/**
 *
 * @author jobe
 */
public class MenukortUI {
    
    public static void visMenukort(ArrayList<Pizza> pizzaliste)
    {
        System.out.println("***** Menukort: *******");
        for (Pizza pizza : pizzaliste) {
            System.out.println(pizza.getPizzaID() + ": "+ pizza.getNavn());   
        }
    }
}
