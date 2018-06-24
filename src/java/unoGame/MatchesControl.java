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
    private  final int P_LIMIT = 2;
        
	private  List<Match> matches = new ArrayList<>();
        private  List<Match> preMatch = new ArrayList<>();
	
        public  void preMatch(Player p1, Player p2) {
            Match match = new Match();
            match.addPlayer(p1);
            match.addPlayer(p2);
            preMatch.add(match);
        }
	public  void addPlayer(Player p) {
                
            boolean isPreMatched = false;
            for (Match m : preMatch){
                if (m.getPlayer(p.getpId()) != null){
                    m.preMatchcontroller++;
                    if (m.preMatchcontroller == 2){
                        matches.add(m);
                        m.setIsMatchStarted();
                        return;
                    }
                    isPreMatched = true;
                }
            }
            if (isPreMatched)
                return;
            
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
        
        public  Match findMatch(int pId){
            for(Match match : matches){
                if(match.getPlayer(pId) != null && match.getPlayer(pId).getpId() == pId)
                    return match;
            }
            return null;
        }
}
