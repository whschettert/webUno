/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.unows;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import unoGame.Match;
import unoGame.MatchesControl;
import unoGame.Player;
import unoGame.PlayerCollections;

/**
 *
 * @author Wagner_Schettert
 */
@WebService(serviceName = "UnoWebService")
public class UnoWebService{

    private boolean preRegistered;    
    private int MAX_PLAYERS = 1000; //2 each match = 500 matches
    private ArrayList<Player> preRegistro = new ArrayList<Player>();
    
    private MatchesControl matches = new MatchesControl();    
    private PlayerCollections fullListOfPlayers = new PlayerCollections();
    
    @WebMethod(operationName = "preRegistro")
    public int preRegistro(@WebParam(name = "pNameOne") String pNameOne, @WebParam(name = "pIdOne") int pIdOne, @WebParam(name = "pNameTwo") String pNameTwo, @WebParam(name = "pIdTwo") int pIdTwo) {
        Player p1 = new Player(pNameOne,pIdOne);
        Player p2 = new Player(pNameOne,pIdTwo);
        
        fullListOfPlayers.registerPlayer(p1);
        fullListOfPlayers.registerPlayer(p2);
        preRegistro.add(p1);
        preRegistro.add(p2);
        
        preRegistered = true;
        return 0;
    }
    
    /**
     * Web service operation
     */    
    @WebMethod(operationName = "registraJogador")
    public int registraJogador(@WebParam(name = "name") String name) {
        int idTobeCreated;        
        if (preRegistered){                        
            matches.addPlayer(fullListOfPlayers.findPlayer(name));
            preRegistro.remove(fullListOfPlayers.findPlayer(name));
            if(preRegistro.isEmpty())
                preRegistered = false;
            return fullListOfPlayers.findPlayer(name).getpId();
        }
        if (fullListOfPlayers.findPlayer(name).getpName() == name)
            return -1; //jogador ja existe
        
        if (fullListOfPlayers.getSize() > MAX_PLAYERS)
            return -2; //numero max de jogadores atingido
        
        idTobeCreated = fullListOfPlayers.getSize()+1;
        Player p = new Player(name,idTobeCreated);
        try{
            matches.addPlayer(p);
            fullListOfPlayers.registerPlayer(p);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }        
        
        return idTobeCreated;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encerraPartida")
    public int encerraPartida(@WebParam(name = "idJogador") Integer idJogador) {
        List<Player> playersInGame = matches.findMatch(idJogador).getAllPlayers();
        
        try{
            for(Player player : playersInGame){
                fullListOfPlayers.removePlayer(player.getpName());            
            }
        }
        catch(Exception e){
            return -1;
        }        
        return 0;
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "temPartida")
    public int temPartida(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);
            
            if (m!=null && m.getState()== "TIMEOUT"){
                encerraPartida(idJogador);
                return -2;
            }
            
            if(m!=null && m.getState()== "WAITING FOR PLAYERS"){
                return 0;
            }
            
            if(m!=null && m.getState()== "IN PROGRESS"){
                if(m.getCurPlayer().getpId() == idJogador)
                    return 1;
                else
                    return 2;
            }                
                
        }        
        catch(Exception e){
            return -1;
        }
        return 0;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemOponente")
    public String obtemOponente(@WebParam(name = "idJogador") Integer idJogador) {
        try{ 
            Match m = matches.findMatch(idJogador);
            return m.getOpPlayer().getpName();
        }
        catch(Exception e){
            return "";
        }        
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ehMinhaVez")
    public int ehMinhaVez(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);
            if(m.getPNumbers() < 2)
                return -2;            
            
            if(m.getWinner().getpId()==idJogador)
                return 2;//you win
            if(m.getWinner().getpId()!=idJogador)
                return 3;//you lose
            if(m.getWinner()==null)
                return 4;//tie
            
            
            if(m.getPlayer(idJogador).isMyTurn())
                return 1;//sim
            if(m.getPlayer(idJogador).isMyTurn() == false)
                return 0;//nao            
            
            if(m.getWO().getpId() == idJogador)
                return 5;//win by wo
            if(m.getWO().getpId() != idJogador)
                return 6;//lose by wo
            
        }
        catch(Exception e){
            return -1;
        }
        return 0;//nao
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemNumCartasBaralho")
    public int obtemNumCartasBaralho(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);
            if(m.getPNumbers() < 2)
                return -2;  
            return m.getTrunkSize();
        }
        catch(Exception e){
            return -1;
        }            
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemNumCartas")
    public int obtemNumCartas(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);
            if(m.getPNumbers() < 2)
                return -2; 
            return m.getPlayer(idJogador).getNumOfCards();
        }
        catch(Exception e){
            return -1;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemNumCartasOponente")
    public int obtemNumCartasOponente(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);
            if(m.getPNumbers() < 2)
                return -2; 
            return m.getPlayer(idJogador).getOpponent().getNumOfCards();
        }
        catch(Exception e){
            return -1;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "mostraMao")
    public String mostraMao(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);            
            return m.getPlayer(idJogador).showCardsInHand();
        }
        catch(Exception e){
            return "";
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemCartaMesa")
    public String obtemCartaMesa(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);            
            return m.getCurCard().toString();
        }
        catch(Exception e){
            return "";
        }        
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemCorAtiva")
    public int obtemCorAtiva(@WebParam(name = "idJogador") Integer idJogador) {
        try{
            Match m = matches.findMatch(idJogador);            
            if(m.getPNumbers() < 2)
               return -2;
            switch(m.getCurCard().getColor()){
                case R:
                    return 3;
                case G:
                    return 2;
                case B:
                    return 0;
                case Y:
                    return 1;
            }
        }
        catch(Exception e){
            return -1;
        }
        return -1;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "compraCarta")
    public int compraCarta(@WebParam(name = "idJogador") Integer idJogador) {
         try{
            Match m = matches.findMatch(idJogador);  
            if(m.getPNumbers() < 2)
               return -2;
            if(m.getCurPlayer().getpId()!=idJogador)
                return -3;
            return m.giveCardToPlayer(idJogador);            
        }
        catch(Exception e){
            return -1;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "jogaCarta")
    public int jogaCarta(@WebParam(name = "idJogador") Integer idJogador, @WebParam(name = "indexOfCard") int indexOfCard, @WebParam(name = "colorOfCard") int colorOfCard) {
        try{
            Match m = matches.findMatch(idJogador);  
            if(m.getPNumbers() < 2)
               return -2;
            if(m.getCurPlayer().getpId()!=idJogador)
               return -3;
            return m.getPlayer(idJogador).playCard(indexOfCard,colorOfCard);
        }
        catch(Exception e){
            return -1;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemPontos")
    public int obtemPontos(@WebParam(name = "idJogador") Integer idJogador) {
        //TODO write your implementation code here:
        return 0;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemPontosOponente")
    public int obtemPontosOponente(@WebParam(name = "idJogador") Integer idJogador) {
        //TODO write your implementation code here:
        return 0;
    }    
}
