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
    Z("0"), O("1"), TW("2"), TH("3"),
    FO("4"), FI("5"), SI("6"), SE("7"),
    E("8"), N("9"), SKIP("Pu"), REVERSE("In"),
    P_TWO("+2"), P_FOUR("C4"), WILD("Cg");
	
    private String text;	
	
    ECardType(String text){
        this.text = text;
    }
	
    @Override
    public String toString() {
        return text;
    }
}
