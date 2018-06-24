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
        private Card curCard;	
	private Player curPlayer; //player
	private Player opPlayer; //opponent	
	private Stack<Card> trunk = new Stack<>();
	private Stack<Card> discardPile = new Stack<>();
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
		dealInitialCards();
		putCardInDiscardPile(this.trunk.pop());
		isMatchStarted = true;                
	}
	
	/**
	 * Deal the initial card to both players
	 */
	private void dealInitialCards() {
		for (int i = 0; i < 13; i++) {
			// if even, opponent gets card, otherwise player gets one
			if (i%2 == 0)
				players.get(1).addCards(null, trunk.pop());
			else
				players.get(0).addCards(null, trunk.pop());
		}		
	}
        
        public int giveCardToPlayer(int pId){
            players.get(pId).addCards(null, trunk.pop());
            return 1;
        }
	
	/*
	 * add a card to the discard pile
	 */
	public void putCardInDiscardPile(Card card) {
		curCard = card;
		discardPile.push(card);		
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
            return trunk.size();
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
		return curPlayer;
	}
        
        public Player getPlayer(int pId){
            for (Player p : players) {
                if (p.getpId()==pId)
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
	public Player getOpPlayer() {
		return opPlayer;
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
