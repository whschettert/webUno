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
public class MatchesControl {
    private static final int P_LIMIT = 2;
	
	private static List<Match> matches = new ArrayList<>();
	
	public static void addPlayer(Player p) {
                
            if (matches.size() > 0){
		for (Match match : matches) {
			if(match.getPNumbers() < P_LIMIT) {
				match.addPlayer(p);
				if(match.getNumPlayers() == P_LIMIT)
					match.setIsMatchStarted();
				return;
			}
		}
            }
            Match match = new Match();
            match.addPlayer(p);
            matches.add(match);            
	}
        
        public static Match findMatch(int pId){
            for(Match match : matches){
                if(match.getPlayer(pId).getpId() == pId)
                    return match;
            }
            return null;
        }
}
