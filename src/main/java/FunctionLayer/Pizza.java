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
public class Pizza {
    
    private int pizzaID;

    @Override
    public String toString() {
        return "Pizza{" + "pizzaID=" + pizzaID + ", navn=" + navn + ", pris=" + pris + ", beskrivelse=" + beskrivelse + '}';
    }
    private String navn;
    private int pris;
    private String beskrivelse;

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public Pizza(int pizzaID, String navn, int pris, String beskrivelse) {
        this.pizzaID = pizzaID;
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
    }
    
    
}
