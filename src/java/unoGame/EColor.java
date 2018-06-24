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
public enum EColor {
    R("Vm"), Y("Am"), G("Vd"), B("Az"), S("*");
	
	private String text;
	
	EColor(String text){
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
