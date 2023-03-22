package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    // --- Instance Variables --- //
    private int whoseTurn;
    private int player0Score;
    private int player1Score;
    private int currTotal;
    private int dieValue;


    /** Default constructor for the game state */
    public PigGameState() {
        whoseTurn = 0;
        player0Score = 0;
        player1Score = 0;
        currTotal = 0;
    }//default ctor

    /**
     * Copy constructor of the default game state
     * @param original   The game state object we are copying over
     */
    public PigGameState(PigGameState original) {
        whoseTurn = original.whoseTurn;
        player0Score = original.player0Score;
        player1Score = original.player1Score;
        currTotal = original.currTotal;
        dieValue = original.dieValue;
    }//ctor

    ///////////////////////////
    // --- GETTER METHODS ---//
    ///////////////////////////
    public int getTurn() {return whoseTurn;}//getTurn
    public int getPlayer0Score() {return player0Score;}//getPlayer0Score
    public int getPlayer1Score() {return player1Score;}//getPlayer1Score
    public int getCurrTotal() {return currTotal;}//getCurrTotal
    public int getDieValue() {return dieValue;}//getDieValue

    ////////////////////////////
    // --- SETTER METHODS --- //
    ////////////////////////////
    public void setWhoseTurn(int turn) {whoseTurn = turn;}//setWhoseTurn

    public void flipTurn() {
        if (whoseTurn == 0) {
            whoseTurn = 1;
        } else {
            whoseTurn = 0;
        }
    }//setWhoseTurn
    public void setPlayer0Score(int score) {player0Score = score;}//setPlayer0Score
    public void setPlayer1Score(int score) {player1Score = score;}//setPLayer1Score
    public void setCurrTotal(int total) {currTotal = total;}//setCurrTotal
    public void setDieValue(int value) {dieValue = value;}//setDieValue
}
