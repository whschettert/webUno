/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoGame;

/**
 *
 * @author Wagner_Schettert
 */
public enum ECardType {
    Z("0", 0), O("1", 1), TW("2", 2), TH("3", 3),
    FO("4", 4), FI("5", 5), SI("6", 6), SE("7", 7),
    E("8", 8), N("9", 9), SKIP("Pu", 20), REVERSE("In", 20),
    P_TWO("+2", 20), P_FOUR("C4", 50), WILD("Cg", 50);
	
    private String text;
    private int points;
	
    ECardType(String text, int points){
        this.text = text;
        this.points = points;
    }
	
    public int getPoints(){
        return this.points;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
