/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import FunctionLayer.Ordre;

/**
 *
 * @author jobe
 */
public class OrdreFacade {
    
    public static Ordre createOrder(Ordre ordreObject) throws Exception
    {
        return OrdreMapper.createOrder(ordreObject);
    }
    
    
}
