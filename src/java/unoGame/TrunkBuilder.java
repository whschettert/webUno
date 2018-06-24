/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 */
package unoGame;

import java.util.Random;
import java.util.Stack;

/**
 * @author Wagner_Schettert
 *
 */
public class TrunkBuilder {

	public Stack<Card> buildTrunk(int matchId) {
	int redCount = 75;
	int yellowCount = 25;
	int greenCount = 50;
	int blueCount = 0;
	int specialCount = 100;
		
	Stack<Card> trunk = new Stack<>();
		
	trunk.push(new Card(blueCount, EColor.B, ECardType.Z));
	trunk.push(new Card(greenCount, EColor.G, ECardType.Z));
	trunk.push(new Card(yellowCount, EColor.Y, ECardType.Z));
	trunk.push(new Card(redCount, EColor.R, ECardType.Z));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;
		
        for (int i = 0; i < 2; i++) {
                trunk.push(new Card(blueCount, EColor.B, ECardType.O));
                trunk.push(new Card(greenCount, EColor.G, ECardType.O));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.O));
                trunk.push(new Card(redCount, EColor.R, ECardType.O));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.TW));
                trunk.push(new Card(greenCount, EColor.G, ECardType.TW));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.TW));
                trunk.push(new Card(redCount, EColor.R, ECardType.TW));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.TH));
                trunk.push(new Card(greenCount, EColor.G, ECardType.TH));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.TH));
                trunk.push(new Card(redCount, EColor.R, ECardType.TH));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.FO));
                trunk.push(new Card(greenCount, EColor.G, ECardType.FO));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.FO));
                trunk.push(new Card(redCount, EColor.R, ECardType.FO));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.FI));
                trunk.push(new Card(greenCount, EColor.G, ECardType.FI));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.FI));
                trunk.push(new Card(redCount, EColor.R, ECardType.FI));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.SI));
                trunk.push(new Card(greenCount, EColor.G, ECardType.SI));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.SI));
                trunk.push(new Card(redCount, EColor.R, ECardType.SI));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.SE));
                trunk.push(new Card(greenCount, EColor.G, ECardType.SE));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.SE));
                trunk.push(new Card(redCount, EColor.R, ECardType.SE));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.E));
                trunk.push(new Card(greenCount, EColor.G, ECardType.E));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.E));
                trunk.push(new Card(redCount, EColor.R, ECardType.E));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.N));
                trunk.push(new Card(greenCount, EColor.G, ECardType.N));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.N));
                trunk.push(new Card(redCount, EColor.R, ECardType.N));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.P_TWO));
                trunk.push(new Card(greenCount, EColor.G, ECardType.P_TWO));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.P_TWO));
                trunk.push(new Card(redCount, EColor.R, ECardType.P_TWO));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.SKIP));
                trunk.push(new Card(greenCount, EColor.G, ECardType.SKIP));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.SKIP));
                trunk.push(new Card(redCount, EColor.R, ECardType.SKIP));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;

        trunk.push(new Card(blueCount, EColor.B, ECardType.REVERSE));
                trunk.push(new Card(greenCount, EColor.G, ECardType.REVERSE));
                trunk.push(new Card(yellowCount, EColor.Y, ECardType.REVERSE));
                trunk.push(new Card(redCount, EColor.R, ECardType.REVERSE));
        blueCount++;
        greenCount++;
        yellowCount++;
        redCount++;
        }

        for (int i = 0; i < 4; i++) {
                trunk.push(new Card(specialCount, EColor.S, ECardType.WILD));
                specialCount++;                
        }
        
        for (int i = 0; i < 4; i++) {                
                trunk.push(new Card(specialCount, EColor.S, ECardType.P_FOUR));
                specialCount++;
        }

        return shuffle(matchId, trunk);
	}
	
	public Stack<Card> shuffle(int matchId, Stack<Card> trunk){
		Random r = new Random(matchId);
		int size = trunk.size();
		for (int i = 0; i < size; i++) {
            int aux = r.nextInt(size);
            Card card = trunk.get(i);
            trunk.add(i,trunk.get(aux));
            trunk.add(aux,card);
        }
        for (int i = 0; i < size*size; i++) {
            int r1 = r.nextInt(size);
            int r2 = r.nextInt(size);
            Card card = trunk.get(i);
            trunk.add(r1, trunk.get(r2));
            trunk.add(r2, card);
        }
        return trunk;
	}

}

