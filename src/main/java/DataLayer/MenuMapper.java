/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

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
    
    
    public static void getMenu() throws Exception
    {
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
                System.out.println("Pizza_id: " + pizzaId + ": " + pizzaNavn);    
            }
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
                System.out.println(ex.getMessage());
                throw new Exception(ex.getMessage());
        }
    }    
    
    
    
    
    
}
