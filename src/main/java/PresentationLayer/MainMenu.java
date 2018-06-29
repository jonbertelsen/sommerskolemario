/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Menukort;
import FunctionLayer.Ordre;
import java.util.Scanner;

/**
 *
 * @author jobe
 */
public class MainMenu {
    
    
    
    public static void showMainMenu()
    {
        Menukort.initierMenukort();
        
        boolean afslut = false;
        
        Scanner console = new Scanner(System.in);
        
        while (!afslut)
        {  
            System.out.println("Hovedmenu:");
            System.out.println("1. Vis menukort");
            System.out.println("2. Opret ordre");
            System.out.println("5. Afslut");
            
            String inputString = console.next();
            
            switch (inputString)
            {
                case "1": visMenukort();break;
                case "2": createOrder();break;
                case "5": afslut = true;break;
            
            }
  
        }
    }
    
    public static void visMenukort()
    {
        // FunctionLayer.Menukort menu = new FunctionLayer.Menukort();
         
        
        try
        {   
            MenukortUI.visMenukort(Menukort.getPizzaliste());
        }
        catch (Exception ex)
        {
            System.out.println("Der er sket en fejl: " + ex.getMessage());
        }
    
    }
    
    public static void createOrder()
    {
        Ordre nyOrdre;
        
        try
        {
            nyOrdre = DataLayer.OrdreFacade.createOrder(new Ordre(1140, 157, 1));
            System.out.println(nyOrdre.toString());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
