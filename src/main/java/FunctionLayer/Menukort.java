/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;


/**
 *
 * @author jobe
 */
public class Menukort {
    
    private static ArrayList<Pizza> pizzaliste;

    public static void initierMenukort() {
      if (pizzaliste == null)
      {
          try
          {
            pizzaliste = DataLayer.MenuFacade.getMenu();
          }
          catch (Exception ex)
          {
              System.out.println(ex);
          }
      }
    }

    public static ArrayList<Pizza> getPizzaliste() {
        return pizzaliste;
    }
    
    
    
    
    
    public static void addPizza(Pizza pizzaItem)
    {
    
    }
    
    
    
    
}
