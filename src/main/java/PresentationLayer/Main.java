/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

/**
 *
 * @author jobe
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Velkommen til Marios Pizzabar");
        try
        {
            DataLayer.MenuMapper.getMenu();
        }
        catch (Exception ex)
        {
            System.out.println("Der er sket en fejl: " + ex.getMessage());
        }
    }
    
}
