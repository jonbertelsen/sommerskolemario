/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Ordre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jobe
 */
class OrdreMapper 
{

    protected static Ordre createOrder(Ordre ordreObject) throws Exception
    {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Ordre (afhentningstid, samletpris, kunde_id) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ordreObject.getAfhentningstid());
            ps.setInt(2, ordreObject.getSamletpris());
            ps.setInt(3, ordreObject.getKunde_id());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            ordreObject.setOrdre_id(id);
            return ordreObject;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }
            
    
    
    
}
