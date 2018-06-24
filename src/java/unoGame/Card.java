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
    private int id = 0;
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
     * @param color of card
     * @param type of card
     */
    public Card(EColor color, ECardType type) {
        this.color = color;
        this.type = type;
    }

    /**
     * @param color of card
     */
    public Card(EColor color) {
        this.color = color;
    }

    /**
     * @param type of card
     */
    public Card(ECardType type) {
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
     * @param set type of card
     */
    public void setType(ECardType type) { this.type = type; }

    /**
     * @return color of card
     */
    public EColor getColor() {
        return color;
    }

    /**
     * @param set color of card
     */
    public void setColor(EColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return type.toString() + "/"+ color.toString();
}
    
}
