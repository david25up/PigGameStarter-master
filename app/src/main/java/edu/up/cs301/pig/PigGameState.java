package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    private int whoseTurn;
    private int player0Score;
    private int player1Score;
    private int currTotal;
    private int dieValue;


    /** Default constructor for the game state */
    public PigGameState() {
    }//default ctor

    /**
     * Copy constructor of the default game state
     * @param original   The game state object we are copying over
     */
    public PigGameState(PigGameState original) {
    }//ctor

    public int getTurn() {return whoseTurn;}

    public int getPlayer0Score() {return player0Score;}

    public int getPlayer1Score() {return player1Score;}

    public int getCurrTotal() {return currTotal;}

    public int getDieValue() {return dieValue;}

    public void setWhoseTurn(int turn) {whoseTurn = turn;}

    public void setPlayer0Score(int score) {player0Score = score;}

    public void setPlayer1Score(int score) {player1Score = score;}

    public void setCurrTotal(int total) {currTotal = total;}

    public void setDieValue(int value) {dieValue = value;}
}
