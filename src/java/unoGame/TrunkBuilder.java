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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wagner_Schettert
 *
 */
public class TrunkBuilder {

    public static int DECK_SIZE = 108;
    
    public Card[] buildTrunk(int matchId) {
        
        Random random = new Random(matchId);

        int[] trunk = new int[DECK_SIZE];
        for (int i = 0; i < DECK_SIZE; i++) {
            trunk[i] = i;
        }

        for (int c = 0; c < DECK_SIZE; ++c) {
            int outra = random.nextInt(DECK_SIZE);
            int aux = trunk[c];
            trunk[c] = trunk[outra];
            trunk[outra] = aux;
        }
        for (int c = 0; c < DECK_SIZE * DECK_SIZE; c++) {
            int c1 = random.nextInt(DECK_SIZE);
            int c2 = random.nextInt(DECK_SIZE);
            int aux = trunk[c1];
            trunk[c1] = trunk[c2];
            trunk[c2] = aux;
        }
        
        Card[] trunkStack = new Card[DECK_SIZE];
        for (int c = 0; c < DECK_SIZE; c++){
            int cardId = trunk[c];
            if (cardId >= 0 && cardId <= 24){
                EColor cardColor = EColor.B;
                if (cardId == 0)    
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.Z));
                if (cardId == 1 || cardId == 2)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.O));
                if (cardId == 3 || cardId == 4)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TW));
                if (cardId == 5 || cardId == 6)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TH));
                if (cardId == 7 || cardId == 8)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FO));
                if (cardId == 9 || cardId == 10)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FI));
                if (cardId == 11 || cardId == 12)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SI));
                if (cardId == 13 || cardId == 14)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SE));
                if (cardId == 15 || cardId == 16)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.E));
                if (cardId == 17 || cardId == 18)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.N));
                if (cardId == 19 || cardId == 20)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SKIP));
                if (cardId == 21 || cardId == 22)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.REVERSE));
                if (cardId == 23 || cardId == 24)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.P_TWO));
            }
            if (cardId >= 25 && cardId <= 49){
                EColor cardColor = EColor.Y;
                if (cardId == 25)    
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.Z));
                if (cardId == 26 || cardId == 27)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.O));
                if (cardId == 28 || cardId == 29)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TW));
                if (cardId == 30 || cardId == 31)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TH));
                if (cardId == 32 || cardId == 33)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FO));
                if (cardId == 34 || cardId == 35)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FI));
                if (cardId == 36 || cardId == 37)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SI));
                if (cardId == 38 || cardId == 39)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SE));
                if (cardId == 40 || cardId == 41)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.E));
                if (cardId == 42 || cardId == 43)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.N));
                if (cardId == 44 || cardId == 45)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SKIP));
                if (cardId == 46 || cardId == 47)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.REVERSE));
                if (cardId == 48 || cardId == 49)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.P_TWO));
            }
            if (cardId >= 50 && cardId <= 74){
                EColor cardColor = EColor.G;
                if (cardId == 50)    
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.Z));
                if (cardId == 51 || cardId == 52)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.O));
                if (cardId == 53 || cardId == 54)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TW));
                if (cardId == 55 || cardId == 56)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TH));
                if (cardId == 57 || cardId == 58)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FO));
                if (cardId == 59 || cardId == 60)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FI));
                if (cardId == 61 || cardId == 62)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SI));
                if (cardId == 63 || cardId == 64)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SE));
                if (cardId == 65 || cardId == 66)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.E));
                if (cardId == 67 || cardId == 68)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.N));
                if (cardId == 69 || cardId == 70)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SKIP));
                if (cardId == 71 || cardId == 72)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.REVERSE));
                if (cardId == 73 || cardId == 74)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.P_TWO));
            }
            if (cardId >= 75 && cardId <= 99){
                EColor cardColor = EColor.R;
                if (cardId == 75)    
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.Z));
                if (cardId == 76 || cardId == 77)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.O));
                if (cardId == 78 || cardId == 79)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TW));
                if (cardId == 80 || cardId == 81)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.TH));
                if (cardId == 82 || cardId == 83)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FO));
                if (cardId == 84 || cardId == 85)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.FI));
                if (cardId == 86 || cardId == 87)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SI));
                if (cardId == 88 || cardId == 89)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SE));
                if (cardId == 90 || cardId == 91)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.E));
                if (cardId == 92 || cardId == 93)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.N));
                if (cardId == 94 || cardId == 95)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.SKIP));
                if (cardId == 96 || cardId == 97)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.REVERSE));
                if (cardId == 98 || cardId == 99)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.P_TWO));
            }
            if (cardId >= 100){
                EColor cardColor = EColor.S;
                if (cardId >= 100 && cardId <= 103)    
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.WILD));
                if (cardId >= 104 || cardId <= 107)
                    trunkStack[c] = (new Card(cardId, cardColor, ECardType.P_FOUR));
            }
        }
        
        return trunkStack;
    }

}

