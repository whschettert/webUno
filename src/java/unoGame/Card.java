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
public class Card {
    private int id;
    private EColor color;
    private ECardType type;

    /**
     * @param id of card
     * @param color of card
     * @param type of card
     */
    public Card(int id, EColor color, ECardType type) {
        this.id = id;
        this.color = color;
        this.type = type;
    }

    /**
     * @return id of card
     */
    public int getId() { return id; }

    /**
     * @return type of card
     */
    public ECardType getType() {
        return type;
    }

    /**
     * @return color of card
     */
    public EColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return type.toString() + "/"+ color.toString();
    }
    
}
