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
public class PlayerCollections {

        private static int lastId;
	private static List<Player> fullListOfPlayers;

	public static void PlayerCollections(){
		fullListOfPlayers = new ArrayList<>();
                lastId=0;
	}

	public static int registerPlayer(Player p) {
		if (fullListOfPlayers.contains(p))
			return -1;
		fullListOfPlayers.add(p);
                lastId = p.getpId();
		return p.getpId();
	}

	public static Player findPlayer(int id) {
		for (Player p : fullListOfPlayers)
			if (p.getpId() == id)
				return p;
		return null;
	}
        
        public static Player findPlayer(String pName){
            for (Player p: fullListOfPlayers)
                   if(p.getpName().equals(pName))
                       return p;
            return null;
        }
        
        public static int getSize(){
            return fullListOfPlayers.size();
        }
        
        public static void removePlayer(String pName){
            for (Player p: fullListOfPlayers)
                   if(p.getpName().equals(pName))
                       fullListOfPlayers.remove(p);
        }
}

