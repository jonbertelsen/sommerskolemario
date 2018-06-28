/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.util.Scanner;

/**
 *
 * @author jobe
 */
public class MainMenu {
    
    public static void showMainMenu()
    {
        
        boolean afslut = false;
        
        Scanner console = new Scanner(System.in);
        
        while (!afslut)
        {  
            System.out.println("Hovedmenu:");
            System.out.println("1. Vis menukort");
            System.out.println("5. Afslut");
            
            String inputString = console.next();
            
            switch (inputString)
            {
                case "1": visMenukort();break;
                case "5": afslut = true;break;
            
            }
  
        }
    }
    
    public static void visMenukort()
    {
        // FunctionLayer.Menukort menu = new FunctionLayer.Menukort();
         
        try
        {   
            MenukortUI.visMenukort(DataLayer.MenuFacade.getMenu())  ;
        }
        catch (Exception ex)
        {
            System.out.println("Der er sket en fejl: " + ex.getMessage());
        }
    
    }
    
}
