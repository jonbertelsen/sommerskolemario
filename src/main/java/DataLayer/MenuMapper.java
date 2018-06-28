/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author jobe
 */
public class MenuMapper {
    
    
    protected static ArrayList<Pizza> getMenu() throws Exception
    {
        ArrayList<Pizza> pizzaliste = new ArrayList();
        
        try 
        {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM pizza";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) 
            {
                
                int pizzaId = rs.getInt("pizza_id");
                String pizzaNavn = rs.getString("navn");
                String pizzaBeskrivelse = rs.getString("beskrivelse");
                int pris = rs.getInt("pris");
                
                pizzaliste.add(new Pizza(pizzaId, pizzaNavn, pris, pizzaBeskrivelse));
                
               // System.out.println("Pizza_id: " + pizzaId + ": " + pizzaNavn);    
            }
            return pizzaliste;
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
                System.out.println(ex.getMessage());
                throw new Exception(ex.getMessage());
        }
    }    
    
    
    
    
    
}
