/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author jobe
 */
public class Ordre {
    
    private int ordre_id;
    private int afhentningstid;
    private int samletpris;
    private int kunde_id;

    public Ordre(int ordre_id, int afhentningstid, int samletpris, int kunde_id) {
        this.ordre_id = ordre_id;
        this.afhentningstid = afhentningstid;
        this.samletpris = samletpris;
        this.kunde_id = kunde_id;
    }

    public int getOrdre_id() {
        return ordre_id;
    }

    public void setOrdre_id(int ordre_id) {
        this.ordre_id = ordre_id;
    }

    public int getAfhentningstid() {
        return afhentningstid;
    }

    public void setAfhentningstid(int afhentningstid) {
        this.afhentningstid = afhentningstid;
    }

    public int getSamletpris() {
        return samletpris;
    }

    public void setSamletpris(int samletpris) {
        this.samletpris = samletpris;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public void setKunde_id(int kunde_id) {
        this.kunde_id = kunde_id;
    }
    
    
    
    
    
    
    
    
}
