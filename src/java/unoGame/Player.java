/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoGame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wagner_Schettert
 */
public class Player {
    private int pId;
    private String pName;
    private List<Card> cardsInHand = new ArrayList<>();
    private boolean myTurn;
    private Player opp;

	public Player(String pName) {
		this.pName = pName;
	}
        
        public Player(String pName, int pId) {
		this.pName = pName;
                this.pId = pId;
	}

	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}

	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}

        public boolean isMyTurn() {
          return myTurn;
        }

        public void setMyTurn(boolean myTurn) {
          this.myTurn = myTurn;
        }

	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		int points = 0;
                for (Card c : cardsInHand)
                    points += c.getType().getPoints();
                return points;
	}
        
        public int getNumOfCards(){
            return cardsInHand.size();
        }

        public Player getOpponent() {
            return opp;
        }

        public void setOpp(Player opp) {
            this.opp = opp;
        }
        
        
	
	/**
	 * 
	 * @return all the cards in the player hand
	 */
	public String showCardsInHand() {        
        String handString = ""; 
        for (Card card: cardsInHand) {
            if (handString == ""){
                handString = card.toString();
            } else {
                handString += "|" + card.toString();
            }
        }            
        
        return handString; 
	}
	
	/**
	 * 
	 * @param index specified card
	 * @return the card that was played
	 */
	public int playCard(int index, int color) {            
            switch(cardsInHand.get(index).getType()){
                //case WILD:
                    
            }
            return 0;
	}
	
	/**
	 * 
	 * @param cards, can be Null. add collection of cards, as per a draw 2 or 4
	 * @param card, can be Null. add a card
	 */
	public void addCards(ArrayList<Card> cards, Card card){
		if (cards!=null)
			cardsInHand.addAll(cards);
		else
			cardsInHand.add(card);
	}
	
	@Override
	public String toString() {
		return "Name: "+ pName + " ID: " + pId;
	}    
}
