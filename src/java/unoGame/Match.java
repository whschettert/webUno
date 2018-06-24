/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Wagner_Schettert
 */
public class Match {
        public int preMatchcontroller = 0;
        private Card curCard;	
	private int currentCounter;
	private Card[] trunk;
        private int trunkSize;
	private List<Card> discardPile = new ArrayList<>();
	private List<Player> players = new ArrayList<>(); 
	private boolean isTrunkEmpty = false;
	private boolean isMatchOver = false;
	private boolean isMatchStarted = false;
	private boolean playerLeft;
	private int matchId;
	private String state;
        private long timeout;
        
	/**
	 * 
	 */
	public Match() {
            state="WAITING FOR PLAYERS";
	}

	/**
	 * Starts Match with a new match ID
	 * deal the cards to both players
	 * add a card to the discard pile
	 */
	public void setIsMatchStarted() {
		matchId = 0;
		for(Player p : players)
			matchId += p.getpId();
		this.trunk = new TrunkBuilder().buildTrunk(matchId);
                this.trunkSize = TrunkBuilder.DECK_SIZE;
		dealInitialCards();
                Card topCard = popCard();
                while(topCard.getColor() == EColor.S){
                    topCard = popCard();
                }
                if (topCard.getType() == ECardType.SKIP || topCard.getType() == ECardType.REVERSE){
                    currentCounter = 1;
                } else if (topCard.getType() == ECardType.P_TWO){
                    currentCounter = 1;
                    players.get(0).addCards(null, popCard());
                    players.get(0).addCards(null, popCard());
                } else {
                    currentCounter = 0;
                }
		putCardInDiscardPile(topCard);
		isMatchStarted = true;                
	}
        
        private Card popCard(){
            int pos = this.trunkSize - 1;
            this.trunkSize--;
            return this.trunk[pos];
        }
        
        private Player getCurrentPlayer(){
            return players.get(Math.abs(currentCounter) % 2);
        }
	
	/**
	 * Deal the initial card to both players
	 */
	private void dealInitialCards() {
		for (int i = 0; i < 7; i++) {
                    players.get(0).addCards(null, popCard());
                    players.get(1).addCards(null, popCard());
		}		
	}
        
        public int giveCardToPlayer(int pId){
            players.get(pId).addCards(null, popCard());
            return 1;
        }
	
	/*
	 * add a card to the discard pile
	 */
	public void putCardInDiscardPile(Card card) {
		curCard = card;
		discardPile.add(card);		
	}
	
	/**
	 *
	 */
	public void endMatch() {
		// TO DO
		isMatchOver = true;
	}
	
	/**
	 * @return the winner player
	 */
	public Player getWinner() {
		Player curWinner = players.get(0);
		if (players.get(1).getPoints() > curWinner.getPoints())
                    curWinner = players.get(1);		
                else 
                    return null;
		return curWinner;
	}

	public int getNumPlayers(){
		return players.size();
	}

	/**
	 * @category getters
	 * @return the curCard
	 */
	public Card getCurCard() {
		return curCard;
	}
        
        public int getTrunkSize(){
            return this.trunkSize;
        }

	/**
	 * @category getters
	 * @return matchId
	 */
	public int getMatchId() {
		return matchId;
	}

        public String getState() {
           return state;
        }
        
        public void setState(String state){
            this.state = state;
        }
        
        public Player getWO(){
            return players.get(0);
        }
        
	
	/**
	 * @category getters
	 * @return the curPlayer
	 */
	public Player getCurPlayer() {
		return getCurrentPlayer();
	}
        
        public Player getPlayer(int pId){
            for (Player p : players) {
                if (p.getpId() == pId)
                    return p;
            }
            return null;
        }
        
        public List<Player> getAllPlayers(){
            return players;
        }

	/**
	 * @category getters
	 * @return the opPlayer
	 */
	public Player getOpPlayer(int pId) {
            for (Player p : players) {
                if (p.getpId() != pId)
                    return p;
            }
            return null;
	}

	/**
	 * @category getters
	 * @return the isTrunkEmpty
	 */
	public boolean isTrunkEmpty() {
		return isTrunkEmpty;
	}

	/**
	 * @category getters
	 * @return the isMatchOver
	 */
	public boolean isMatchOver() {
		return isMatchOver;
	}

	/**
	 * @category getters
	 * @return the isMatchStarted
	 */
	public boolean isMatchStarted() {
		return isMatchStarted;
	}

	public int getPNumbers() {
		return players.size();
	}

	public void addPlayer(Player p) {
		players.add(p);		
	}
        
        public synchronized void matchTimer(){
            new Thread(){
                public void run(){
                    try{
                        while(true){
                            Thread.sleep(120000);
                            if(state == "WAITING FOR PLAYERS")
                                state = "TIMEOUT";
                        }
                            
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
}
