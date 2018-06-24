/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoGame;

/**
 * 
 * @author Wagner_Schettert
 *
 */
public class UnoGame implements IUnoGame{

    public UnoGame() {
        super();
    }
    
    /**
     * 
     * @param pNameOne
     * @param pOneID
     * @param pNameTwo
     * @param pTwoID
     * @return 
     */
    @Override
    public int preRetristro(String pNameOne, int pOneID, String pNameTwo, int pTwoID){
        return 0;
    }

    /**
     * @param pName string with player name
     * @return user ID - unique identifier
     * -1 if user already exists
     * -2 if max number of players reached
     * @
     */
    @Override
    public int registraJogador(String pName)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -1 if error, 0 if ok
     * @
     */
    @Override
    public int encerraPartida(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 Timeout
     * -1 Error
     * 0 no match yet
     * 1 match found and you are player one
     * 2 match found and you are player two
     * @
     */
    @Override
    public int temPartida(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return empty string for error, otherwise opponent name
     * @
     */
    @Override
    public String obtemOponente(int pID)  {
        return null;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * 0 not your turn
     * 1 yes your turn
     * 2 you won
     * 3 you lose
     * 4 there was a tie
     * 5 win by WO
     * 6 lose by WO
     * @
     */
    @Override
    public int ehMinhaVez(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * otherwise number of cards left in the trunk
     * @
     */
    @Override
    public int obtemNumCartasBaralho(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * otherwise number of cards in the player hand
     * @
     */
    @Override
    public int obtemnumCartas(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -2 error no two players yet
     * -1 error
     * otherwise number of cards in the opponent hand
     * @
     */
    @Override
    public int obtemNumCartasOponente(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return empty String if error, otherwise String with the cards in player hand
     * @
     */
    @Override
    public String mostraMao(int pID)  {
        return null;
    }

    /**
     * @param pID user ID
     * @return empty String if error, otherwise String with the card in the top of the discard pile
     * @
     */
    @Override
    public String obtemCartaMesa(int pID)  {
        return null;
    }

    /**
     * @param pID user ID
     * @return value of the current color card
     * 0 for blue
     * 1 for yellow
     * 2 for green
     * 3 for red
     * @
     */
    @Override
    public int obtemCorAtiva(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return 0 for success, -1 for error
     * @
     */
    @Override
    public int compraCarta(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return 1 for ok
     * 0 invalid card
     * -1 player not found
     * -2 match not started
     * -3 invalid param
     * -4 not player turn
     * @
     */
    @Override
    public int jogaCarta(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -1 player not found
     * -2 match not started
     * -3 match not finished
     * otherwise points for player
     * @
     */
    @Override
    public int obtemPontos(int pID)  {
        return 0;
    }

    /**
     * @param pID user ID
     * @return -1 player not found
     * -2 match not started
     * -3 match not finished
     * otherwise points for opponent
     * @
     */
    @Override
    public int obtemPontosOponente(int pID)  {
        return 0;
    }
}